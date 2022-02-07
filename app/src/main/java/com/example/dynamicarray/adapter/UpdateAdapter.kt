package com.example.dynamicarray.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.dynamicarray.Api.load
import com.example.dynamicarray.Data.Data
import com.example.dynamicarray.Data.ResponseItem
import com.example.dynamicarray.R

class UpdateAdapter(): RecyclerView.Adapter<UpdateAdapter.ViewHolder>() {
    private var PreList = ArrayList<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rvlayout,parent,false)
        return ViewHolder(view)
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updatelist(list:ArrayList<Data>){
        PreList = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = PreList[position].key
      //  holder.image.load(PreList[position].meta.icon)
        holder.card.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return PreList.size
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val text = itemView.findViewById<TextView>(R.id.name)
        val image = itemView.findViewById<ImageView>(R.id.imageView)
        val card = itemView.findViewById<CardView>(R.id.card)
    }
}