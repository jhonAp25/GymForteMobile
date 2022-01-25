package com.example.gymfortemobile.View.ui.horario

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.gymfortemobile.databinding.FragmentHorarioBinding

class HorarioFragment : Fragment() {


    private lateinit var  binding : FragmentHorarioBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHorarioBinding.inflate(inflater,container,false)

        return binding.root
    }


}