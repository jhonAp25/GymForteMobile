package com.example.gymfortemobile.ViewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gymfortemobile.Model.*
import com.example.gymfortemobile.Model.API.InscripcionApi
import com.example.gymfortemobile.Model.API.ReservaApi
import com.example.gymfortemobile.Model.API.TrainerApi
import com.example.gymfortemobile.Util.RetrofitHelpers
import com.example.gymfortemobile.View.ui.MainActivity
import com.example.gymfortemobile.View.ui.home.IncripcionFragment
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

/// si funciona
    val inscripcionInfo = MutableLiveData<DefaultResponse>()

    fun getinscInfo (inscripcio: Inscribir){

        val response = RetrofitHelpers.getRetrofit().create(InscripcionApi::class.java).
        addinscripcion(inscripcio)

        response.enqueue(object : Callback<DefaultResponse> {
            override fun onResponse(
                call: Call<DefaultResponse>,
                response: Response<DefaultResponse>
            ) {
                response.body()?.let { inscripcion ->
                    inscripcionInfo.postValue(inscripcion)

               //     Log.e("JHON", response.body().toString())
                    Log.e("JHON", response.body()?.mensaje.toString())
                }
            }

            override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                Log.e("JHON", t.message.toString())
            }
        } )

    }

    val inscripInfo = MutableLiveData<DefaultResponse>()
    fun getinscInfor (clase:Long,estado:String,reserva:Long){


        val response =RetrofitHelpers.getRetrofit().create(InscripcionApi::class.java).
        addInscripcio(clase,estado,reserva)

            response.enqueue(object: Callback<DefaultResponse> {
                override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                    Log.e("JHON", "no"+t.message.toString())
                }

                override fun onResponse(call: Call<DefaultResponse>, response: Response<DefaultResponse>)
                {
                    response.body()?.let {
                    inscripInfo.postValue(it)
                        Log.e("JHON", "si"+response.body()?.mensaje.toString())

                        /*Log.e("JHON", response.body().toString())*/
                }
                   // Log.e("JHON", "si"+response.body()?.mensaje.toString())
                }

            })

    }
}