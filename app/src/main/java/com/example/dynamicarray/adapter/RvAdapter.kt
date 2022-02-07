package com.example.dynamicarray.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.dynamicarray.Api.load
import com.example.dynamicarray.Data.Data
import com.example.dynamicarray.Data.ResponseItem
import com.example.dynamicarray.R
import com.example.dynamicarray.UpdateActivity
import java.util.*
import kotlin.collections.ArrayList

class RvAdapter(val context:Context, var PreList:ArrayList<ResponseItem>,val  final:(i:Int)->Unit,val back:(list:ArrayList<ResponseItem>)->Unit):RecyclerView.Adapter<RvAdapter.ViewHolder>() {


    var stack = Stack<ArrayList<ResponseItem>?>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rvlayout,parent,false)

        return ViewHolder(view)
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updatelist(list:ArrayList<ResponseItem>){
        PreList = list

        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = PreList[position].key
        holder.image.load(PreList[position].meta.icon)


        holder.card.setOnClickListener {
            back.invoke(PreList)
            stack.push(PreList)
           updatelist(PreList[position].data)
            inte()
        }



    }
    fun inte()
    {
        if(PreList.isEmpty())
        {

            val x =   stack.peek()
            val pass = x?.get(0)?.value
            final.invoke(pass!!)

        }
    }


    override fun getItemCount(): Int {
      return PreList.size
    }
     class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
         val text = itemView.findViewById<TextView>(R.id.name)
         val image = itemView.findViewById<ImageView>(R.id.imageView)
         val card  = itemView.findViewById<CardView>(R.id.card)

    }
}