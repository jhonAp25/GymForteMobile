package com.example.gymfortemobile.Model.API

import com.example.gymfortemobile.Model.Disciplina
import retrofit2.Call
import retrofit2.http.GET

interface DisciplinaApi {
    @GET("/disciplina")
    fun listarDisciplinas():Call< List<Disciplina>>
}