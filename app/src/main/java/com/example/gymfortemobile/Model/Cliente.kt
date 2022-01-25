package com.example.gymfortemobile.Model

import com.google.gson.annotations.SerializedName

class Cliente (
    @SerializedName("id")
    val id: Long?,
    @SerializedName("nombre")
    val nombre: String?,
    @SerializedName("apellido")
    val apellido: String?,
    @SerializedName("sexo")
    val sexo: String?,
    @SerializedName("celular")
    val celular: Long?,
    @SerializedName("correo")
    val correo:  String?,
    @SerializedName("foto")
    val foto:  String?

)