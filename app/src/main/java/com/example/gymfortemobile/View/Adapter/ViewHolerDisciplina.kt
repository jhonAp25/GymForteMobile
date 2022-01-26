package com.example.gymfortemobile.View.Adapter

import android.view.View
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.gymfortemobile.Model.Disciplina
import com.example.gymfortemobile.R
import com.example.gymfortemobile.View.ui.home.HomeFragmentDirections
import com.example.gymfortemobile.databinding.ItemCardDisciplinaBinding
import com.squareup.picasso.Picasso

class ViewHolerDisciplina(view:View):RecyclerView.ViewHolder(view) {
    val binding = ItemCardDisciplinaBinding.bind(view)

    fun bind(disciplina: Disciplina){
        binding.txtNombreDisciplina.text= disciplina.nombre
        Picasso.get().load(disciplina.imagen).into(binding.imgDisciplina)
        binding.txtidd.text= disciplina.id.toString()

        binding.idCardDisciplina.setOnClickListener {
            val amountTv: TextView = it!!.findViewById(R.id.txtidd)
            val amount = amountTv.text.toString().toLong()
            val action = HomeFragmentDirections.actionNavigationHomeToClaseFragment(amount)
            it.findNavController().navigate(action)
        }
    }
}