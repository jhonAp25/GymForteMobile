package com.example.gymfortemobile.View.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gymfortemobile.Model.Pago
import com.example.gymfortemobile.R


class AdapterPago (private val Lista:List<Pago>): RecyclerView.Adapter<ViewHolderPago>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPago {

                val layoutInflater: LayoutInflater = LayoutInflater.from( parent.context )
                return ViewHolderPago( layoutInflater.inflate( R.layout.item_card_pago, parent, false ) )
        }

        override fun onBindViewHolder(holder: ViewHolderPago, position: Int) {
                val item: Pago =  Lista[ position ]
                holder.bind( item )


        }




        override fun getItemCount(): Int {
                return Lista.size
        }


}