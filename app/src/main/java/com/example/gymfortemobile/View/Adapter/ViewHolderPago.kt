package com.example.gymfortemobile.View.Adapter

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.gymfortemobile.Model.Pago
import com.example.gymfortemobile.databinding.ItemCardPagoBinding


class ViewHolderPago(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemCardPagoBinding.bind(view)

    fun bind(pago: Pago){
        binding.txtEstado.text=pago.estado
        binding.txtMes.text= pago.mensualidad?.mes
        if (pago.estado.toString().equals("Pendiente")){
            binding.cardEstado.setBackgroundColor(Color.parseColor("#F20544") )
        }else{
            binding.cardEstado.setBackgroundColor(Color.parseColor("#006D68") )
        }


    }
}
