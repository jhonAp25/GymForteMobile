package com.example.gymfortemobile.View.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gymfortemobile.Model.Disciplina
import com.example.gymfortemobile.ViewModel.DisciplinaViewModel
import com.example.gymfortemobile.databinding.FragmentDashboardBinding
import com.example.gymfortemobile.databinding.FragmentHomeBinding

class DashboardFragment : Fragment() {


    private lateinit var  binding : FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }


}