package com.example.e_commerceapp.ui.filter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceapp.R
import com.google.android.material.card.MaterialCardView

class FilterColorAdapter(private val context: Context , private val list : ArrayList<String> , private val clickedColor :(String) -> Unit) : RecyclerView.Adapter<FilterColorAdapter.MyViewHolder>() {

    private var clickedCV = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_color_recycler , parent , false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val data = list[position]
        val colorInt = data.toColorInt()
        holder.innerCV.setCardBackgroundColor(colorInt)

        holder.innerCV.setOnClickListener {
            clickedColor(data)
            clickedCV = position
            notifyDataSetChanged()
        }

        if (clickedCV == position){
            holder.outerCV.strokeColor = colorInt
        }else{
            holder.outerCV.strokeColor = Color.TRANSPARENT
        }

    }
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val outerCV: MaterialCardView = itemView.findViewById(R.id.outerCV)
        val innerCV: MaterialCardView = itemView.findViewById(R.id.innerCV)

    }
}