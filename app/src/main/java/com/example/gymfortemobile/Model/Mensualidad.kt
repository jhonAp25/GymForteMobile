package com.example.gymfortemobile.Model

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

class Mensualidad (
    @SerializedName("id")
    val id: Long?,
    @SerializedName("fechaPago")
    val fechaInicio: String?,
    @SerializedName("fechaFinal")
    val fechaFinal: String?,
    @SerializedName("mes")
    val mes: String?,
    @SerializedName("estado")
    val estado: String?,

)