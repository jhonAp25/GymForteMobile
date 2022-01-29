package com.example.gymfortemobile.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gymfortemobile.Model.API.InscripcionApi
import com.example.gymfortemobile.Model.API.ReservaApi
import com.example.gymfortemobile.Model.API.TrainerApi
import com.example.gymfortemobile.Model.Clase
import com.example.gymfortemobile.Model.Inscripcion
import com.example.gymfortemobile.Model.Reserva
import com.example.gymfortemobile.Model.Trainer
import com.example.gymfortemobile.Util.RetrofitHelpers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Field

class InscripcionViewModel: ViewModel() {
    val trainerInfo = MutableLiveData<Trainer>()

    fun getTrainerInfo (id:Long){
        val response = RetrofitHelpers.getRetrofit().create(TrainerApi::class.java).
        getbyTrainer(id)

        response.enqueue(object : Callback<Trainer> {
            override fun onResponse(
                call: Call<Trainer>,
                response: Response<Trainer>
            ) {
                response.body()?.let {trainer->
                    trainerInfo.postValue(trainer)

                    Log.e("JHON" , response.body().toString())
                }
            }
            override fun onFailure(call: Call<Trainer>, t: Throwable) {
                Log.e("JHON" , "no se pudo")
            }



        } )
    }

    val reservaInfo = MutableLiveData<Reserva>()

    fun getReservaInfo (id:Long){
        val response = RetrofitHelpers.getRetrofit().create(ReservaApi::class.java).
        byreserva(id)

        response.enqueue(object : Callback<Reserva> {
            override fun onResponse(
                call: Call<Reserva>,
                response: Response<Reserva>
            ) {
                response.body()?.let {reserva->
                    reservaInfo.postValue(reserva)

                    Log.e("JHON" , response.body().toString())
                }
            }
            override fun onFailure(call: Call<Reserva>, t: Throwable) {
                Log.e("JHON" ,  t.message.toString())
            }



        } )
    }

/// no funciona
    val inscripcionInfo = MutableLiveData<Inscripcion>()

    fun getinscInfo (inscripcion: Inscripcion){

        val response = RetrofitHelpers.getRetrofit().create(InscripcionApi::class.java).
        addinscripcion(inscripcion)

        response.enqueue(object : Callback<Inscripcion> {
            override fun onResponse(
                call: Call<Inscripcion>,
                response: Response<Inscripcion>
            ) {
                response.body()?.let {inscripcion->
                    inscripcionInfo.postValue(inscripcion)

                    Log.e("JHON" , response.body().toString())
                }
            }
            override fun onFailure(call: Call<Inscripcion>, t: Throwable) {
                Log.e("JHON" ,  t.message.toString())
            }



        } )

    }
}