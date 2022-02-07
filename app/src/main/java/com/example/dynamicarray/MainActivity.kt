package com.example.dynamicarray

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dynamicarray.Api.Api
import com.example.dynamicarray.Api.Calls
import com.example.dynamicarray.Data.Response
import com.example.dynamicarray.Data.ResponseItem
import com.example.dynamicarray.adapter.RvAdapter
import com.example.dynamicarray.adapter.UpdateAdapter
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var adapter:RvAdapter
    var stack = Stack<ArrayList<ResponseItem>?>()
    private lateinit var rv:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv =  findViewById<RecyclerView>(R.id.rv)
        adapter = RvAdapter(this,ArrayList(),::showfinal,::back)
        Calls.getsubs(::OnSuccess)
        supportActionBar?.hide()
        findViewById<ImageView>(R.id.imageView2).setOnClickListener {
            backpress()
        }
    }
    fun OnSuccess(list:ArrayList<ResponseItem>){
        show(list)
    }
    fun show(list:ArrayList<ResponseItem>){
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter  = RvAdapter(this,list,::showfinal,::back)
    }

     @SuppressLint("NotifyDataSetChanged")
     fun backpress() {
         if(stack.isNotEmpty()) {
             val item = stack.pop()
             adapter.updatelist(item!!)
             rv.adapter = RvAdapter(this, item, ::showfinal, ::back)
             val tx =   findViewById<TextView>(R.id.finall)
             tx.visibility =  View.INVISIBLE

         }
      }
    fun showfinal(i:Int){
      val tx =   findViewById<TextView>(R.id.finall)
        tx.visibility =  View.VISIBLE
        tx.text = i.toString()

    }
    fun back( list:ArrayList<ResponseItem>) {
        stack.push(list)
        stack.size
    }


}