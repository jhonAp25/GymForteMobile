package com.example.gymfortemobile.Model.API


import com.example.gymfortemobile.Model.Pago
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PagoApi {
    @GET("/pago/{id}")
    fun listarPago(@Path("id")id:Long): Call<List<Pago>>
}

