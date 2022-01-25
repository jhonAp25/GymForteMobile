package com.example.gymfortemobile.Model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

class Clase (
    @SerializedName("id")
    val id: Long?,
    @SerializedName("cuposmax")
    val cuposmax: Long?,
    @SerializedName("horaIni")
    val horaIni: String?,
    @SerializedName("horaFin")
    val horaFin: String?,
    @SerializedName("disciplina")
    val disciplina: Disciplina?,
    @SerializedName("trainers")
    val trainers: Trainer?,
    @SerializedName("clase")
    val clase: Clase?



)