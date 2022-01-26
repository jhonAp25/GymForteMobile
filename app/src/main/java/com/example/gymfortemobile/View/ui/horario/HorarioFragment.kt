package com.example.gymfortemobile.View.ui.horario

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.gymfortemobile.Model.CalendarDateModel
import com.example.gymfortemobile.Model.Inscripcion
import com.example.gymfortemobile.R
import com.example.gymfortemobile.Util.HorizontalItemDecoration
import com.example.gymfortemobile.View.Adapter.AdapterCalendar
import com.example.gymfortemobile.View.Adapter.AdapterInscripciones
import com.example.gymfortemobile.ViewModel.HorarioViewModel
import com.example.gymfortemobile.databinding.FragmentClaseBinding

import com.example.gymfortemobile.databinding.FragmentHorarioBinding
import java.text.SimpleDateFormat
import java.util.*

class HorarioFragment : Fragment() {


    private val inscripcionViewModel: HorarioViewModel by viewModels()
    private val inscripcion = mutableListOf<Inscripcion>()
    private lateinit var adapterins: AdapterInscripciones





    /**
     * Primero, obtengamos la lista de fechas del calendario actual que necesitamos usar.
     * Para eso,necesitaremos la variable de la instancia del Calendario,
     * ArrayList y SimpleDateFormat.
     */

    private val sdf = SimpleDateFormat("MMMM yyyy", Locale.getDefault())
    private val cal = Calendar.getInstance()
    private val currentDate = Calendar.getInstance()
    private val dates = ArrayList<Date>()


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

        monthCalendar.set(Calendar.DAY_OF_MONTH,1)

        /**Ahora usaremos el bucle while para almacenar todas las fechas en una matriz
        y este bucle continuará hasta el tamaño máximo de días en el mes actual*/
        while (dates.size < maxDaysInMonth) {
            dates.add(monthCalendar.time)
            calendarList.add(CalendarDateModel(monthCalendar.time))
            //Y después de agregar la fecha del primer día del mes actual,
            // solicitaremos la fecha del día siguiente.
            // Para eso, agregaremos 1 día más al calendario.
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }
        calendarList2.clear()
        calendarList2.addAll(calendarList)
        adapter.setData(calendarList)
    }

    /**
     * Necesitamos el mes siguiente y el anterior al hacer clic en la flecha.
     * Así que aquí solo tenemos que agregar 1 mes y -1 mes del calendario actual.
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

        //selecciona el dia y carga el listado de clases inscritas
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

    private val onCLicked  = object : AdapterCalendar.OnItemClickListener{
        override fun onClicked(dia: String) {
            GetInscripcion(dia)
        }
    }
    private fun GetInscripcion(dia:String){

        /************************************** RESPONSE-SHARED-PREFERENCES  *************/
        val shared = context?.getSharedPreferences("usuario", Context.MODE_PRIVATE)

        val idCliente = shared?.getString("id", "0 ").toString().toLong()

        val fecha= "2022-01-$dia"
        val idc:Long
        idc=idCliente
        inscripcionViewModel.getListaInscripciones(idc,fecha)
    }
    private fun RecyclerViewDisci( rv: RecyclerView){
        adapterins = AdapterInscripciones( inscripcion )
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