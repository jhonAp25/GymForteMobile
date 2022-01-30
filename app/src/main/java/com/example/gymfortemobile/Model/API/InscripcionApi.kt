package com.example.gymfortemobile.Model.API


import androidx.annotation.Nullable
import com.example.gymfortemobile.Model.DefaultResponse
import com.example.gymfortemobile.Model.Inscribir
import com.example.gymfortemobile.Model.Inscripcion
import retrofit2.Call
import retrofit2.http.*

interface InscripcionApi {

    @GET("/inscripcion/buscar/{idc}/{fecha}")
    fun listarClases(@Path("idc") idc: Long,
                       @Path("fecha") fecha: String):
            Call<List<Inscripcion>>

    @Headers("Content-Type: application/json")
    @FormUrlEncoded
    @POST("/inscripcion/realizar")
    fun addInscripcio(
                      @Field("clase") clase: Long,
                      @Field("estado") estado: String,
                      @Field("reserva") reserva: Long): Call<DefaultResponse>

    //@Headers("Content-Type: application/json")
    @POST("/inscripcion/realizar")
    fun addinscripcion(@Body inscripcion: Inscribir): Call<DefaultResponse>
}