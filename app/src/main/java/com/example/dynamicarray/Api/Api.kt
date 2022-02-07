package com.example.dynamicarray.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(Service::class.java)
}