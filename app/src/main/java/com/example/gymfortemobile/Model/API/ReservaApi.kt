package com.example.gymfortemobile.Model.API

import com.example.gymfortemobile.Model.Reserva
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ReservaApi {
    @GET("/reserva/buscarReservaByCliente/{id}")
    fun byreserva(@Path("id")id:Long): Call<Reserva>
}