package com.example.gymfortemobile.View.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.gymfortemobile.Model.Inscripcion
import com.example.gymfortemobile.databinding.ItemTrainerInscrBinding
import com.squareup.picasso.Picasso

class ViewHolderInscripcion (view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemTrainerInscrBinding.bind(view)

    fun bind(inscripcion: Inscripcion){
        binding.txtNombre.text= inscripcion.clase?.trainers?.nombre//+", "+inscripcion.clase?.trainers?.apellido
        Picasso.get().load(inscripcion.clase?.trainers?.foto).into(binding.imgTrainer)

    }
}