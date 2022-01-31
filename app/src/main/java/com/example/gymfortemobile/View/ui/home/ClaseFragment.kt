package com.example.gymfortemobile.View.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.gymfortemobile.Model.CalendarDateModel
import com.example.gymfortemobile.R
import com.example.gymfortemobile.Util.HorizontalItemDecoration
import com.example.gymfortemobile.View.Adapter.AdapterCalendar
import com.example.gymfortemobile.View.Adapter.AdapterInscripcion
import com.example.gymfortemobile.View.Adapter.ViewModelCalendar
import com.example.gymfortemobile.databinding.FragmentClaseBinding
import java.text.SimpleDateFormat
import java.util.*
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.gymfortemobile.Model.Clase


class ClaseFragment : Fragment() {

    private val argsss: ClaseFragmentArgs by navArgs()

    private val inscripcionViewModel: ViewModelCalendar by viewModels()
    private val inscripcion = mutableListOf<Clase>()
    private lateinit var adapterins: AdapterInscripcion

    /**
     * Primero, obtengamos la lista de fechas del calendario actual que necesitamos usar.
     * Para eso,necesitaremos la variable de la instancia del Calendario,
     * ArrayList y SimpleDateFormat.
     */

    private val sdf = SimpleDateFormat("MMMM yyyy", Locale.getDefault())
    private val mm = SimpleDateFormat("MM", Locale.getDefault())
    private val cal = Calendar.getInstance()
    private val currentDate = Calendar.getInstance()
    private val dates = ArrayList<Date>()

    private val currentDay = currentDate[Calendar.DAY_OF_MONTH]
    // selected date
    private var selectedDay: Int = currentDay
    // all days in month
    private val calendarList2 = ArrayList<CalendarDateModel>()
    private lateinit var adapter: AdapterCalendar
    private lateinit var binding: FragmentClaseBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClaseBinding.inflate(inflater, container, false)
        val view = binding.root


        setUpAdapter()
        setUpClickListener()
        setUpCalendar()



        //GetInscripcion()
        ViewModelInscripcion()
        RecyclerViewDisci( binding.rvTrainer)

        return view
    }


    /**
     *Ahora tenemos que obtener la lista de fechas actual
     */
    private fun setUpCalendar() {
        val calendarList = ArrayList<CalendarDateModel>()

        binding.tvDateMonth.text = sdf.format(cal.time)
        val monthCalendar = cal.clone() as Calendar

        /**
         *Este código obtendrá el número máximo. de días en el mes actual
         */
        val maxDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
        dates.clear()
        /**
         *Ahora configuraremos el mes calendario actual desde donde debemos comenzar
         */
        var currentPosition = 0
        monthCalendar.set(Calendar.DAY_OF_MONTH,1)

        /**Ahora usaremos el bucle while para almacenar todas las fechas en una matriz
        y este bucle continuará hasta el tamaño máximo de días en el mes actual*/
        while (dates.size < maxDaysInMonth) {
            // get position of selected day
            if (monthCalendar[Calendar.DAY_OF_MONTH] == selectedDay)
                currentPosition = dates.size
            dates.add(monthCalendar.time)
            calendarList.add(CalendarDateModel(monthCalendar.time))
            //Y después de agregar la fecha del primer día del mes actual,
            // solicitaremos la fecha del día siguiente.
            // Para eso, agregaremos 1 día más al calendario.
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }
        /**
         * Si inicia la aplicación, centra el día actual, pero solo si el día actual
         * no es de los primeros (1, 2, 3) ni de los últimos (29, 30, 31).
         */
        when {
            currentPosition > 2 -> binding.recyclerView!!.scrollToPosition(currentPosition - 3)
            maxDaysInMonth - currentPosition < 2 -> binding.recyclerView!!.scrollToPosition(currentPosition)
            else -> binding.recyclerView!!.scrollToPosition(currentPosition)
        }
        calendarList2.clear()
        calendarList2.addAll(calendarList)
        adapter.setData(calendarList)
    }

    /**
     * Necesitamos el mes siguiente y el anterior al hacer clic en la flecha.
     * Así que aquí solo tenemos que agregar 1 mes y -1 mes del calendario actual
     */
    private fun setUpClickListener() {
        binding.ivCalendarNext.setOnClickListener {
            cal.add(Calendar.MONTH, 1)
            setUpCalendar()
        }
        binding.ivCalendarPrevious.setOnClickListener {
            cal.add(Calendar.MONTH, -1)
            if (cal == currentDate)
                setUpCalendar()
            else
                setUpCalendar()
        }
        binding.recyclerView
        //al seleccionar el dia
        adapter.setClickListener(onCLicked)
    }

    private fun setUpAdapter() {
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.single_calendar_margin)
        binding.recyclerView.addItemDecoration(HorizontalItemDecoration(spacingInPixels))
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.recyclerView)
        adapter = AdapterCalendar{ calendarDateModel: CalendarDateModel, position: Int ->
            calendarList2.forEachIndexed { index, calendarModel ->
                calendarModel.isSelected = index == position
            }
            adapter.setData(calendarList2)
        }
        binding.recyclerView.adapter = adapter
    }
    //seleccionar el dia cargara el recicler de clase/trainers
    private val onCLicked  = object : AdapterCalendar.OnItemClickListener{
        override fun onClicked(dia: String) {
            GetInscripcion(dia)
        }
    }
    private fun GetInscripcion(dia:String){
        val mes :String
        mes=mm.format(cal.time)
        //trae el id de home/disciplina
        val amount = argsss.amount
        // cambia al seleccionar el numero del dia
        val fecha:String
        if (dia.toLong()>9){
            fecha= "2022-$mes-$dia"
        }else{
             fecha= "2022-$mes-0$dia"
        }
        binding.txtfech.text=fecha
        val id:Long
        id=amount
        inscripcionViewModel.getListaInscripciones(fecha, id)
    }
    private fun RecyclerViewDisci( rv: RecyclerView){
        adapterins = AdapterInscripcion( inscripcion )
        rv.layoutManager = LinearLayoutManager( context, LinearLayoutManager.VERTICAL, false )
        rv.adapter = adapterins
    }


    private fun ViewModelInscripcion(){


        inscripcionViewModel.listaInscripcion.observe(viewLifecycleOwner ,Observer {
            if( it != null ){
                inscripcion.clear()
                inscripcion.addAll(it)
                adapterins.notifyDataSetChanged()
            }
        })
    }

}