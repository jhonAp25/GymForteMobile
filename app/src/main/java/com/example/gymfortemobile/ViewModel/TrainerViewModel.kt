package com.example.gymfortemobile.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gymfortemobile.Model.API.DisciplinaApi
import com.example.gymfortemobile.Model.API.TrainerApi
import com.example.gymfortemobile.Model.Disciplina
import com.example.gymfortemobile.Model.Trainer
import com.example.gymfortemobile.Util.RetrofitHelpers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrainerViewModel:ViewModel() {
    val listaTrainers = MutableLiveData<List<Trainer>>()
    fun getListaTrainer (){
        val response = RetrofitHelpers.getRetrofit().create(TrainerApi::class.java).listarTrainer()

        response.enqueue(object : Callback<List<Trainer>> {
            override fun onResponse(
                call: Call<List<Trainer>>,
                response: Response<List<Trainer>>
            ) {
                response.body()?.let {
                    if (response.code()== 200){
                        listaTrainers.postValue(it)

                    }else{
                        Log.e("JHON" , "NEL")
                    }

                }
            }

            override fun onFailure(call: Call<List<Trainer>>, t: Throwable) {

            }


        } )
    }
}