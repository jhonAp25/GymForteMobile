package com.example.gymfortemobile.View.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymfortemobile.Model.Disciplina
import com.example.gymfortemobile.Model.Trainer
import com.example.gymfortemobile.View.Adapter.AdapterDisciplina
import com.example.gymfortemobile.View.Adapter.AdapterTrainer
import com.example.gymfortemobile.ViewModel.DisciplinaViewModel
import com.example.gymfortemobile.ViewModel.TrainerViewModel
import com.example.gymfortemobile.databinding.FragmentHomeBinding
import com.squareup.picasso.Picasso

class HomeFragment : Fragment() {



    private val disciplinaViewModel: DisciplinaViewModel by viewModels()
    private val trainerViewModel: TrainerViewModel by viewModels()

    private lateinit var adapterdisci: AdapterDisciplina
    private lateinit var adaptertrainer: AdapterTrainer

    private lateinit var  binding : FragmentHomeBinding

    private val disciplinas = mutableListOf<Disciplina>()
    private val trainers = mutableListOf<Trainer>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(inflater,container,false)






        /************************************** SHARED-PREFERENCES  *************/
        val shared = context?.getSharedPreferences("usuario", Context.MODE_PRIVATE)

        val datos = shared?.getString("nombre", "XXXXX ") +", " + shared?.getString("apellido", "XXXXXX ")
        val imgPerfil = shared?.getString("imgPerfil", "https://i.imgur.com/bUXrPc1.jpg")

        binding.lblNombre.setText(datos)
        Picasso.get().load(imgPerfil).into(binding.imgPerfil)

        if (imgPerfil.equals("null") ){
            Picasso.get().load("https://i.imgur.com/bUXrPc1.jpg").into(binding.imgPerfil)
        }else{
            Picasso.get().load(imgPerfil).into(binding.imgPerfil)
        }




        Log.d("apaza", "DDDDDD$datos")

        GetTrainers()
        GetDisciplina()
        ViewModelTrainers()
        ViewModelDisciplina()
        RecyclerViewDisci( binding.rvListaDisciplina )
        RecyclerViewTrainer( binding.rvTrainer)




        return binding.root ;
    }





    private fun GetTrainers(){
        trainerViewModel.getListaTrainer()
    }

    private fun GetDisciplina(){
        disciplinaViewModel.getListaDisciplina()
    }
    private fun RecyclerViewTrainer( rvtrainer: RecyclerView ){
        adaptertrainer = AdapterTrainer( trainers )
        rvtrainer.layoutManager = LinearLayoutManager( context, LinearLayoutManager.HORIZONTAL, false )
        rvtrainer.adapter = adaptertrainer
    }
    private fun RecyclerViewDisci( rv: RecyclerView ){
        adapterdisci = AdapterDisciplina( disciplinas )
        rv.layoutManager = LinearLayoutManager( context, LinearLayoutManager.HORIZONTAL, false )
        rv.adapter = adapterdisci
    }
    private fun ViewModelTrainers(){
        trainerViewModel.listaTrainers.observe( viewLifecycleOwner, Observer {
            if( it != null ){
                trainers.clear()
                trainers.addAll( it )
                adaptertrainer.notifyDataSetChanged()
            }
        } )
    }
    private fun ViewModelDisciplina(){
        disciplinaViewModel.listaDisciplina.observe( viewLifecycleOwner, Observer {
            if( it != null ){
                disciplinas.clear()
                disciplinas.addAll( it )
                adapterdisci.notifyDataSetChanged()
            }
        } )
    }







}



