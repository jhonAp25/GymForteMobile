package com.example.gymfortemobile.View.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymfortemobile.Model.Disciplina
import com.example.gymfortemobile.View.Adapter.AdapterDisciplina
import com.example.gymfortemobile.ViewModel.DisciplinaViewModel
import com.example.gymfortemobile.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var adapter: AdapterDisciplina

    private val homeViewModel: DisciplinaViewModel by viewModels()
    private lateinit var  binding : FragmentHomeBinding
    private val listaDisciplina = mutableListOf<Disciplina>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(inflater,container,false)

        homeViewModel.getListaDisciplina()
        InitViewModel()
        InitRecyclerViewCate(binding.rvListaDisciplina)

        return binding.root ;
    }









    private fun InitRecyclerViewCate( rvCate: RecyclerView ){
        adapter = AdapterDisciplina(  listaDisciplina  )
        rvCate.layoutManager = LinearLayoutManager( context, LinearLayoutManager.HORIZONTAL, false )
        rvCate.adapter = adapter
    }

    private fun InitViewModel(){
        homeViewModel.listaDisciplina.observe( viewLifecycleOwner, Observer {
            if( it != null ){
                listaDisciplina.clear()
                listaDisciplina.addAll( it )
                adapter.notifyDataSetChanged()
            }
        } )}


}



