package com.example.gymfortemobile.Model.API


import com.example.gymfortemobile.Model.Inscripcion
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface InscripcionApi {

    @GET("/inscripcion/buscar/{idc}/{fecha}/{id}")
    fun listarTrainers(@Path("idc") idc: Long,
                       @Path("fecha") fecha: String,
                       @Path("id") id: Long):
            Call<List<Inscripcion>>
}