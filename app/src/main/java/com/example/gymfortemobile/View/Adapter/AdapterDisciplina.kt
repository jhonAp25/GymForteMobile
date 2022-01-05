package com.example.gymfortemobile.View.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gymfortemobile.Model.Disciplina
import com.example.gymfortemobile.R

class AdapterDisciplina (private val Lista:List<Disciplina>):RecyclerView.Adapter<ViewHolerDisciplina>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolerDisciplina {

        val layoutInflater: LayoutInflater = LayoutInflater.from( parent.context )
        return ViewHolerDisciplina( layoutInflater.inflate( R.layout.item_card_disciplina, parent, false ) )
    }

    override fun onBindViewHolder(holder: ViewHolerDisciplina, position: Int) {
        val item: Disciplina =  Lista[ position ]
        holder.bind( item )
    }

    override fun getItemCount(): Int {
       return Lista.size
    }


}