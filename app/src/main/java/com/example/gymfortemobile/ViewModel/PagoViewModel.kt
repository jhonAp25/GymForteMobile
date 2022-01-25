package com.example.gymfortemobile.ViewModel

import android.util.Log

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gymfortemobile.Model.API.PagoApi
import com.example.gymfortemobile.Model.Pago
import com.example.gymfortemobile.Util.RetrofitHelpers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PagoViewModel : ViewModel() {

    val listaPago = MutableLiveData<List<Pago>>()

    fun getListaPago( id: Long) {

        val response = RetrofitHelpers.getRetrofit().create(PagoApi::class.java).
        listarPago(id)

        response.enqueue(object : Callback<List<Pago>> {
            override fun onResponse(call: Call<List<Pago>>,
                                    response: Response<List<Pago>>
            ) {
                response.body()?.let {

                    if (response.code()== 200){
                        listaPago.postValue(it)
                    }else{
                              Log.e("JHON" , response.body().toString()+"no  SALIO")
                    }


                }
            }

            override fun onFailure(call: Call<List<Pago>>, t: Throwable) {
                Log.e("JHON" ,t.message.toString())
            }

        })
    }
}

