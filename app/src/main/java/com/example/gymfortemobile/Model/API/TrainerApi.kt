package com.example.gymfortemobile.Model.API


import com.example.gymfortemobile.Model.Trainer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TrainerApi {
    @GET("/trainer")
    fun listarTrainer(): Call<List<Trainer>>

    @GET("/trainer/{id}")
    fun getbyTrainer( @Path("id") id: Long):Call<Trainer>
}