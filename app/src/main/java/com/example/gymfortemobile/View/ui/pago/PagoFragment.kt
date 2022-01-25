package com.example.gymfortemobile.View.ui.pago

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymfortemobile.Model.Pago

import com.example.gymfortemobile.View.Adapter.AdapterPago
import com.example.gymfortemobile.View.Adapter.ViewHolderPago
import com.example.gymfortemobile.ViewModel.PagoViewModel
import com.example.gymfortemobile.databinding.FragmentPagoBinding
import com.squareup.picasso.Picasso

class PagoFragment : Fragment() {

    private lateinit var  binding : FragmentPagoBinding
    private lateinit var adapterr: AdapterPago
    private val pagoViewModel: PagoViewModel by viewModels()

    private val listaPago = mutableListOf<Pago>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentPagoBinding.inflate(inflater,container,false)


        getPago()
        InitViewModel()
        InitRecyclerViewPago(binding.rvPago)

        return binding.root
    }


    private fun getPago() {

        /************************************** RESPONSE-SHARED-PREFERENCES  *************/
        val shared = context?.getSharedPreferences("usuario", Context.MODE_PRIVATE)

        val idCliente = shared?.getString("id", "0 ").toString().toLong()






        pagoViewModel.getListaPago( idCliente)
    }

    private fun InitRecyclerViewPago( rvCate: RecyclerView){
        adapterr = AdapterPago(  listaPago  )
        rvCate.layoutManager = LinearLayoutManager( context, LinearLayoutManager.VERTICAL, false )
        rvCate.adapter = adapterr
    }



    private fun InitViewModel(){
        pagoViewModel.listaPago.observe( viewLifecycleOwner, Observer {
            if( it != null ){
                listaPago.clear()
                listaPago.addAll( it )
                adapterr.notifyDataSetChanged()
            }
        } )}


}