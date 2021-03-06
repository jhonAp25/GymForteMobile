package com.example.gymfortemobile.View.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.gymfortemobile.Model.Clase

import com.example.gymfortemobile.R
import com.example.gymfortemobile.View.ui.home.ClaseFragmentDirections


class AdapterInscripcion (private val Lista:List<Clase>):
    RecyclerView.Adapter<ViewHolderInscripcion>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderInscripcion {

        val layoutInflater: LayoutInflater = LayoutInflater.from( parent.context )
        return ViewHolderInscripcion( layoutInflater.inflate( R.layout.item_trainer_inscr, parent, false ) )
    }

    override fun onBindViewHolder(holder: ViewHolderInscripcion, position: Int) {
        val item: Clase =  Lista[ position ]
        holder.bind( item )
        holder.itemView.setOnClickListener {view->

            val amountTv: TextView = view!!.findViewById(R.id.txtid)
            val amountw: TextView = view!!.findViewById(R.id.txtidcla)
            val amountT: TextView = view!!.findViewById(R.id.txtHoraIni)
            val amountTt: TextView = view!!.findViewById(R.id.txtdisc)

            val amountTtt: TextView = view!!.findViewById(R.id.txtdate)

            val amount = amountTv.text.toString().toLong()
            val amoun = amountT.text.toString()
            val amou = amountw.text.toString().toLong()
            val disciplina = amountTt.text.toString()

            val fech = amountTtt.text.toString()

            val action = ClaseFragmentDirections.actionClaseFragmentToIncripcionFragment(amount,
                amoun,amou,disciplina,fech)
            view.findNavController().navigate(action)

        }
    }

    override fun getItemCount(): Int {
        return Lista.size
    }
}