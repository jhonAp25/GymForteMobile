package com.example.gymfortemobile.View.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gymfortemobile.Model.Inscripcion
import com.example.gymfortemobile.R

class AdapterInscripciones (private val Lista:List<Inscripcion>):
    RecyclerView.Adapter<ViewHolderInscripciones>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderInscripciones {

        val layoutInflater: LayoutInflater = LayoutInflater.from( parent.context )
        return ViewHolderInscripciones( layoutInflater.inflate( R.layout.item_card_clases, parent, false ) )
    }

    override fun onBindViewHolder(holder: ViewHolderInscripciones, position: Int) {
        val item: Inscripcion =  Lista[ position ]
        holder.bind( item )
/*        holder.itemView.setOnClickListener {view->

            val amountTv: TextView = view!!.findViewById(R.id.txtid)
            val amount = amountTv.text.toString().toLong()
            val action = ClaseFragmentDirections.actionClaseFragmentToIncripcionFragment(amount)
            view.findNavController().navigate(action)

        }*/
    }

    override fun getItemCount(): Int {
        return Lista.size
    }
}