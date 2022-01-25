package com.example.gymfortemobile.View.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.gymfortemobile.Model.Inscripcion
import com.example.gymfortemobile.R


class AdapterInscripcion (private val Lista:List<Inscripcion>): RecyclerView.Adapter<ViewHolderInscripcion>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderInscripcion {

        val layoutInflater: LayoutInflater = LayoutInflater.from( parent.context )
        return ViewHolderInscripcion( layoutInflater.inflate( R.layout.item_trainer_inscr, parent, false ) )
    }

    override fun onBindViewHolder(holder: ViewHolderInscripcion, position: Int) {
        val item: Inscripcion =  Lista[ position ]
        holder.bind( item )
    }

    override fun getItemCount(): Int {
        return Lista.size
    }
}