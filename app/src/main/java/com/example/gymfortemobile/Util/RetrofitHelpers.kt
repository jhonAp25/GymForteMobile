package com.example.gymfortemobile.Util

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelpers {

    fun getRetrofit() : Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
        client.addInterceptor( logging )

        return Retrofit.Builder().baseUrl("https://idat-gym.herokuapp.com/")
            .client( client.build() )
            .addConverterFactory( GsonConverterFactory.create() )
            .build()
    }
}