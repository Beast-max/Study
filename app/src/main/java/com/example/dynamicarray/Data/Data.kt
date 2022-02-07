package com.example.dynamicarray.Data


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("key")
    val key: String,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("value")
    val value: Int
)