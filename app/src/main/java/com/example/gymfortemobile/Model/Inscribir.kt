package com.example.gymfortemobile.Model

import com.google.gson.annotations.SerializedName

class Inscribir (
    @SerializedName("id")
    val id: Long?,

    @SerializedName("estado")
    val estado: String?,

    @SerializedName("reserva")
    val reservas: Long,
    @SerializedName("clase")
    val clases: Long
    )
