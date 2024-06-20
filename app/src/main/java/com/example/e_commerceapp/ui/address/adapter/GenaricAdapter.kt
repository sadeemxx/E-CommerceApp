package com.example.e_commerceapp.ui.address.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

class GenaricAdapter <T : Any>(private val dataSet : List<T> ,
                               @LayoutRes val layoutId : Int ,
                               val bidingInterface: GenaricAdapterInterface<T> ,
                               val clickEvent :(T) -> Unit ): RecyclerView.Adapter<GenaricAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun <T:Any> bind(item : T , bindingInterface : GenaricAdapterInterface<T> , clickEvent : (T) ->Unit){
            bindingInterface.bindData(item , itemView)
            itemView.setOnClickListener {
                clickEvent(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(layoutId , parent , false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataSet[position]
        holder.bind(data , bidingInterface , clickEvent)
    }

    interface GenaricAdapterInterface<T>{
        fun bindData(item : T , view:View)
    }
}