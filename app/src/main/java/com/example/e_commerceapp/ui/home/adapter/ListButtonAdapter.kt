package com.example.e_commerceapp.ui.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceapp.R

class ListButtonAdapter(private val context : Context, private val list : ArrayList<String>, private val clickedButton : (String) -> Unit): RecyclerView.Adapter<ListButtonAdapter.MyViewHolder>() {

    private var selectedButtonPosition = -1

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val listButton : TextView  = itemView.findViewById(R.id.listButtonTV)
        val listButtonLayout : CardView  = itemView.findViewById(R.id.buttonCV)
        val listButtonLayout1 : ConstraintLayout  = itemView.findViewById(R.id.constraintLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_button , parent , false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("ResourceAsColor", "ResourceType")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = list[position]
        holder.listButton.text = data

        if (selectedButtonPosition == position){

            holder.listButtonLayout1.setBackgroundResource(R.color.colorPrimary)
            holder.listButton.setTextColor((ContextCompat.getColor(context, R.color.white)))
        }else{
            holder.listButton.setTextColor((ContextCompat.getColor(context, R.color.black)))
            holder.listButtonLayout1.setBackgroundResource(Color.TRANSPARENT)
//            holder.listButtonLayout.setBackgroundColor(Color.TRANSPARENT)
        }

        holder.listButtonLayout.setOnClickListener {
            selectedButtonPosition = position
            clickedButton(data)
            notifyDataSetChanged()
        }

    }
}