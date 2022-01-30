package com.example.gymfortemobile.View.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.gymfortemobile.Model.Inscribir
import com.example.gymfortemobile.ViewModel.InscripcionViewModel
import com.example.gymfortemobile.databinding.FragmentInscripcionBinding
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class IncripcionFragment : Fragment() {


    private val argss: IncripcionFragmentArgs by navArgs()

    private lateinit var  binding : FragmentInscripcionBinding

    private lateinit var viewModel: InscripcionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInscripcionBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(InscripcionViewModel::class.java)


        /// si funciona
        binding.btninscribir.setOnClickListener {

            val idcla = argss.amou
            val idreser = binding.txtiid.text.toString().trim().toLong()
            val inscripcion = Inscribir(  id = null,
                clases  = idcla,
                 estado = "string",
                reservas = idreser)
            viewModel.getinscInfo(inscripcion)
            Toast.makeText(context, "Incripción realizada con exito", Toast.LENGTH_SHORT).show()


        }

        initU()
        initUI()

        return binding.root;
    }

    private fun initUI(){
        val amount = argss.amount
        val amoun = argss.amoun

        val id : Long

        id= amount.toLong()
        viewModel.getTrainerInfo(id)

        viewModel.trainerInfo.observe(viewLifecycleOwner, Observer { trainer ->
            binding.txttrainer.text = trainer.nombre+", "+trainer.apellido
            binding.txtdisciplina.text=trainer.disciplinas?.nombre
            binding.txtedad.text=trainer.fechaNac
            binding.txtgenero.text=trainer.genero
            binding.txthora.text=amoun
            binding.txtfechaclas.text="2022-01-22"


            Picasso.get().load(trainer.foto).into(binding.imgtrainer)
        })
    }

    private fun initU(){

        /************************************** RESPONSE-SHARED-PREFERENCES  *************/
        val shared = context?.getSharedPreferences("usuario", Context.MODE_PRIVATE)

        val idCliente = shared?.getString("id", "0 ").toString().toLong()


        viewModel.getReservaInfo(idCliente)

        viewModel.reservaInfo.observe(viewLifecycleOwner, Observer { reserva ->
            binding.txtiid.text= reserva.id.toString()

        })
    }

    private fun showSnackbar(msg:String){
        Snackbar.make(  binding.root ,msg, Snackbar.LENGTH_SHORT).show()
    }


}