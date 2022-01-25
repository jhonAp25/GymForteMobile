package com.example.gymfortemobile.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gymfortemobile.Model.API.DisciplinaApi
import com.example.gymfortemobile.Model.Disciplina
import com.example.gymfortemobile.Util.RetrofitHelpers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class DisciplinaViewModel: ViewModel(){
    val listaDisciplina = MutableLiveData<List<Disciplina>>()
    fun getListaDisciplina (){
        val response = RetrofitHelpers.getRetrofit().create(DisciplinaApi::class.java).listarDisciplinas()

        response.enqueue(object : Callback<List<Disciplina>> {
            override fun onResponse(
                call: Call<List<Disciplina>>,
                response: Response<List<Disciplina>>
            ) {
                response.body()?.let {
                    if (response.code()== 200){
                        listaDisciplina.postValue(it)
                        Log.e("JHON" , response.body().toString())
                    }else{
                        Log.e("JHON" , "NEL")
                    }

                }
            }

            override fun onFailure(call: Call<List<Disciplina>>, t: Throwable) {
                Log.e("Jhon" , "GAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            }

        } )
    }
}

