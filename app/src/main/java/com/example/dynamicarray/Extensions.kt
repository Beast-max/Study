package com.example.dynamicarray.Api

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(Url:String){
    Glide.with(this).load(Url).into(this)
}