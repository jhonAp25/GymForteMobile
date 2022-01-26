package com.example.gymfortemobile.View.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.gymfortemobile.Model.Clase
import com.example.gymfortemobile.Model.Inscripcion
import com.example.gymfortemobile.databinding.ItemCardClasesBinding
import com.example.gymfortemobile.databinding.ItemTrainerInscrBinding
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat

class ViewHolderInscripciones (view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemCardClasesBinding.bind(view)

    fun bind(inscripcion: Inscripcion){
        binding.txtDiscip.text= inscripcion.clase?.disciplina?.nombre
        binding.txtiddd.text= inscripcion.clase?.trainers?.id.toString()
        binding.txthorario.text=inscripcion.clase?.horaIni?.substring(14)+"  -  "+inscripcion.clase?.horaFin?.substring(14)
    }
}