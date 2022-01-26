package com.example.gymfortemobile.View.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.gymfortemobile.ViewModel.InscripcionViewModel
import com.example.gymfortemobile.databinding.FragmentInscripcionBinding
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


        initUI()

        return binding.root;
    }

    private fun initUI(){
        val amount = argss.amount
        val id : Long
        //id = 1
        id= amount.toLong()
        viewModel.getTrainerInfo(id)

        viewModel.trainerInfo.observe(viewLifecycleOwner, Observer { trainer ->
            binding.txttrainer.text = trainer.nombre+", "+trainer.apellido
            binding.txtdisciplina.text=trainer.disciplinas?.nombre
            binding.txtedad.text=trainer.fechaNac
            binding.txtgenero.text=trainer.genero
            binding.txthora.text="9:00"
            binding.txtfechaclas.text="2022-01-22"


            Picasso.get().load(trainer.foto).into(binding.imgtrainer)
        })
    }
}