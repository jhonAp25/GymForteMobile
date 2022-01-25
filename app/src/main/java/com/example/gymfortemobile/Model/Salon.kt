package com.example.gymfortemobile.Model

import com.google.gson.annotations.SerializedName

class Salon (
    @SerializedName("id")
    val id: Long?,
    @SerializedName("capacidad")
    val capacidad: String?,
    @SerializedName("descripcion")
    val descripcion: String?
 )