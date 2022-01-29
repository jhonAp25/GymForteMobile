package com.example.gymfortemobile.View.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.gymfortemobile.Model.Clase
import com.example.gymfortemobile.Model.Inscripcion
import com.example.gymfortemobile.databinding.ItemTrainerInscrBinding
import com.squareup.picasso.Picasso

class ViewHolderInscripcion (view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemTrainerInscrBinding.bind(view)


    fun bind(clase: Clase){
        binding.txtNombre.text= clase.trainers?.nombre+", "+clase.trainers?.apellido
        binding.txtid.text= clase.trainers?.id.toString()
        binding.txtidcla.text= clase.id.toString()
        Picasso.get().load(clase.trainers?.foto).into(binding.imgTrainer)
        binding.txthor.text= clase.horaIni?.substring(14)+" - "+clase.horaFin?.substring(14)

    }
}