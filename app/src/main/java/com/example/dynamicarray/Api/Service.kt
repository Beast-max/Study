package com.example.dynamicarray.Api

import android.telecom.Call
import com.example.dynamicarray.Data.Response
import retrofit2.http.GET

interface Service {
    @GET("a7fa4d82-5479-4945-be59-6813c921e069")
    fun getsubs():retrofit2.Call<Response>
}