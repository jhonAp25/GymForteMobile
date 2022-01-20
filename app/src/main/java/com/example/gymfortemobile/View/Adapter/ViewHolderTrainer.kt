package com.example.gymfortemobile.View.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.gymfortemobile.Model.Disciplina
import com.example.gymfortemobile.Model.Trainer
import com.example.gymfortemobile.databinding.ItemCardDisciplinaBinding
import com.example.gymfortemobile.databinding.ItemCardTrainerBinding
import com.squareup.picasso.Picasso

class ViewHolderTrainer (view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemCardTrainerBinding.bind(view)

    fun bind(trainer: Trainer){
        binding.txtApellido.text= trainer.apellido
        binding.txtDisciplina.text= trainer.disciplinas?.nombre
        Picasso.get().load(trainer.foto).into(binding.imgTrainer)
    }
}