package com.example.gymfortemobile.Model

import com.google.gson.annotations.SerializedName


class Pago(

    @SerializedName("id")
    val id: Long?,
    @SerializedName("fechaPago")
    val fechaPago: String?,
    @SerializedName("descripcion")
    val descripcion: String?,
    @SerializedName("estado")
    val estado: String?,
    @SerializedName("mensualidad")
    val mensualidad:Mensualidad?,
    @SerializedName("reserva")
    val reserva:Reserva?,
    @SerializedName("planpago")
    val panpago:Planpago?,

)