package com.example.gymfortemobile.View.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.gymfortemobile.Model.Disciplina
import com.example.gymfortemobile.databinding.ItemCardDisciplinaBinding
import com.squareup.picasso.Picasso

class ViewHolerDisciplina(view:View):RecyclerView.ViewHolder(view) {
    val binding = ItemCardDisciplinaBinding.bind(view)

    fun bind(disciplina: Disciplina){
        binding.txtNombreDisciplina.text= disciplina.nombre
        Picasso.get().load(disciplina.imagen).into(binding.imgDisciplina)
    }
}