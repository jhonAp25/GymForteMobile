package com.example.gymfortemobile.Model.API

import com.example.gymfortemobile.Model.Clase
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ClaseApi {


    @GET("clase/buscar/{fecha}/{id}")
    fun listarTrainers(@Path("fecha") fecha: String,
                       @Path("id") id:Long):
            Call<List<Clase>>
}