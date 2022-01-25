package com.example.gymfortemobile.Model

import com.google.gson.annotations.SerializedName

class Reserva (

    @SerializedName("id")
    val id: Long?,
    @SerializedName("fecha")
    val fecha: String?,
    @SerializedName("cliente")
    val cliente: Cliente,
    @SerializedName("planpago")
    val planpago:Planpago?,
    @SerializedName("estado")
    val estado:Boolean
    )