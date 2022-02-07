package com.example.dynamicarray.Api

import com.example.dynamicarray.Data.ResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Calls {
    fun getsubs(Onsuccess:(list:ArrayList<ResponseItem>)->Unit){
        Api.api.getsubs().enqueue(object :Callback<com.example.dynamicarray.Data.Response>{
            override fun onResponse(
                call: Call<com.example.dynamicarray.Data.Response>,
                response: Response<com.example.dynamicarray.Data.Response>
            ) {
                if(response.isSuccessful)
                {
                    val response = response.body()
                    if(response!=null){
                        Onsuccess.invoke(response)
                    }
                }

            }

            override fun onFailure(
                call: Call<com.example.dynamicarray.Data.Response>,
                t: Throwable
            ) {
                TODO("Not yet implemented")
            }

        })
    }
}