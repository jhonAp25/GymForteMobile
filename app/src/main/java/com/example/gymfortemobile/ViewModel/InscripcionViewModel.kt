package com.example.gymfortemobile.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gymfortemobile.Model.API.TrainerApi
import com.example.gymfortemobile.Model.Trainer
import com.example.gymfortemobile.Util.RetrofitHelpers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
}