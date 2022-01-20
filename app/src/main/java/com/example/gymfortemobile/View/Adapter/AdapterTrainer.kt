package com.example.gymfortemobile.View.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gymfortemobile.Model.Trainer
import com.example.gymfortemobile.R

class AdapterTrainer(private val Lista:List<Trainer>): RecyclerView.Adapter<ViewHolderTrainer>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTrainer {

        val layoutInflater: LayoutInflater = LayoutInflater.from( parent.context )
        return ViewHolderTrainer( layoutInflater.inflate( R.layout.item_card_trainer, parent, false ) )
    }


    override fun getItemCount(): Int {
        return Lista.size
    }

    override fun onBindViewHolder(holder: ViewHolderTrainer, position: Int) {
        val item: Trainer =  Lista[ position ]
        holder.bind(item)
    }
}