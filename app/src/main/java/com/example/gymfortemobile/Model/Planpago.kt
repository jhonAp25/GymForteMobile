package com.example.gymfortemobile.Model

import com.google.gson.annotations.SerializedName

class Planpago (

@SerializedName("id")
val id: Long?,
@SerializedName( "nombre")
val nombre: String?,
@SerializedName("estado")
val estado: String?,
@SerializedName("inicio")
val inicio: String?,
@SerializedName(  "finn")
val finn:String?,
@SerializedName(  "disciplinas")
val disciplinas:Long?,
@SerializedName( "costo")
val costo:Long?,
)