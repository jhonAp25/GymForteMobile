package com.example.gymfortemobile.Model.API


import com.example.gymfortemobile.Model.Clase
import com.example.gymfortemobile.Model.Inscripcion
import com.example.gymfortemobile.Model.Reserva
import retrofit2.Call
import retrofit2.http.*

interface InscripcionApi {

    @GET("/inscripcion/buscar/{idc}/{fecha}")
    fun listarClases(@Path("idc") idc: Long,
                       @Path("fecha") fecha: String):
            Call<List<Inscripcion>>

 /*   //@Headers("Content-Type: application/json")
    @POST("/inscripcion/realizar")
    fun addinscripcion(@Field("clase") clase: Long,
                       @Field("estado") estado: String,
                       @Field("reserva") reserva: Long): Call<Inscripcion>
*/
    //@Headers("Content-Type: application/json")
    @POST("/inscripcion/realizar")
    fun addinscripcion(@Body inscripcion: Inscripcion): Call<Inscripcion>
}