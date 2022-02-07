package com.example.dynamicarray.Data


import com.google.gson.annotations.SerializedName

data class ResponseItem(
    @SerializedName("data")
    var `data`: ArrayList<ResponseItem>,
    @SerializedName("key")
    val key: String,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("value")
    val value: Int
)