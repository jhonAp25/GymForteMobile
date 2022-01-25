package com.example.gymfortemobile.View.Adapter

import android.util.Log

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gymfortemobile.Model.API.InscripcionApi
import com.example.gymfortemobile.Model.Inscripcion
import com.example.gymfortemobile.Util.RetrofitHelpers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCalendar: ViewModel()  {
    val listaInscripcion = MutableLiveData<List<Inscripcion>>()

    fun getListaInscripciones (idc:Long,fecha:String,id:Long){
        val response = RetrofitHelpers.getRetrofit().create(InscripcionApi::class.java).listarTrainers(idc,fecha,id)


        response.enqueue(object : Callback<List<Inscripcion>> {
            override fun onResponse(
                call: Call<List<Inscripcion>>,
                response: Response<List<Inscripcion>>
            ) {
                response.body()?.let {
                    if (response.code()== 200){
                        listaInscripcion.postValue(it)
                        Log.e("JHON" , response.body().toString())
                    }else{
                        Log.e("JHON" , "NEL")
                    }

                }
            }

            override fun onFailure(call: Call<List<Inscripcion>>, t: Throwable) {
                Log.e("JHON" ,  t.toString())
            }



        } )
    }
}