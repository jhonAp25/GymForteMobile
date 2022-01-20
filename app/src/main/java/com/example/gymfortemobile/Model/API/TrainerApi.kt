package com.example.gymfortemobile.Model.API


import com.example.gymfortemobile.Model.Trainer
import retrofit2.Call
import retrofit2.http.GET

interface TrainerApi {
    @GET("/trainer")
    fun listarTrainer(): Call<List<Trainer>>

}