package com.example.e_commerceapp.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceapp.R

class CategoryViewAdapter(private val context: Context , private val list : ArrayList<String>) : RecyclerView.Adapter<CategoryViewAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_category_list , parent , false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = list[position]
        holder.listItemTV.text = data
    }
    class MyViewHolder (itemView : View): RecyclerView.ViewHolder(itemView) {
        val listItemTV = itemView.findViewById<TextView>(R.id.textView)
    }
}