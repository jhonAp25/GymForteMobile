package com.example.gymfortemobile.Model

import com.google.gson.annotations.SerializedName

class Trainer (
    @SerializedName("id")
    val id: Long? ,
    @SerializedName("nombre")
    val nombre: String? ,
    @SerializedName("apellido")
    val apellido: String? ,
    @SerializedName("dni")
    val dni: String? ,
    @SerializedName("fechaNac")
    val fechaNac: String? ,
    @SerializedName("foto")
    val foto: String? ,
    @SerializedName("descripcion")
    val descripcion: String? ,
    @SerializedName("genero")
    val genero: String? ,
    @SerializedName("peso")
    val peso: String? ,
    @SerializedName("altura")
    val altura: String? ,
    @SerializedName("telefono")
    val telefono: String? ,
    @SerializedName("disciplinas")
    val disciplinas: Disciplina? ,



    )
