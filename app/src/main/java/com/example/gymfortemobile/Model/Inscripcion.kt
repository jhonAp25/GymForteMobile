package com.example.gymfortemobile.Model

import android.widget.TextView
import com.google.gson.annotations.SerializedName

class Inscripcion(
    @SerializedName("id")
    val id: Long?,

    @SerializedName("estado")
    val estado: String?,

    @SerializedName("reserva")
    val reserva: Reserva,
    @SerializedName("clase")
    val clase: Clase
    )