package com.example.gymfortemobile.Model

import com.google.gson.annotations.SerializedName


class Disciplina (
    @SerializedName("id")
    val id: Long?,
    @SerializedName("nombre")
    val nombre: String? ,
    @SerializedName("descripcion")
    val descripcion: String? ,
    @SerializedName("imagen")
    val imagen: String? ,

)