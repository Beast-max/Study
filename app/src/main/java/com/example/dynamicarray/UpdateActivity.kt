package com.example.dynamicarray

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dynamicarray.Data.Data
import com.example.dynamicarray.adapter.UpdateAdapter

class UpdateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        val array = intent.getIntExtra("key",0)
        supportActionBar?.hide()

    }
}