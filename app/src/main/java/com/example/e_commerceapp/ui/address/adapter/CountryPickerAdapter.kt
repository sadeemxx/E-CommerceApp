package com.example.e_commerceapp.ui.address.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceapp.R
import com.example.e_commerceapp.data.model.CountryPickerModel

class CountryPickerAdapter() : RecyclerView.Adapter<CountryPickerAdapter.MyViewHolder>() {

    private lateinit var countryList : List<CountryPickerModel>
    private lateinit var cityList :List<String>
    private lateinit var countryName: ((String) -> Unit)

    constructor(countryList : List<CountryPickerModel> , countryName : (String) -> Unit ) : this() {
        this.countryList = countryList
        this.countryName = countryName
        this.cityList = emptyList()

    }

    constructor(cityList : List<String> ,  ) : this() {
        this.cityList = cityList.sorted()
        this.countryList = emptyList()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_country_recyclerview , parent , false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return when {
            countryList != null -> countryList.size
            cityList != null -> cityList.size
            else -> 0
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val data  = list[position]
//        holder.countryNameTV.text = data.countryName
//        holder.countryCodeTV.text = data.countryCode.toString()
//
//        holder.countryCL.setOnClickListener {
////            countryCode(data.countryCode)
//            countryName("(${data.countryCode}) ${data.countryName}")
//            notifyDataSetChanged()
//        }

        when{
            countryList !=null ->{
                val data  = countryList[position]
                holder.countryNameTV.text = data.countryName
                holder.countryCodeTV.text = data.countryCode.toString()

                holder.countryCL.setOnClickListener {
//            countryCode(data.countryCode)
                    countryName("(${data.countryCode}) ${data.countryName}")
                    notifyDataSetChanged()
                }
            }
            cityList != null ->{
                val data = cityList[position]
                holder.countryNameTV.text = data
                holder.countryCodeTV.visibility = View.GONE
//                holder.countryCL.setOnClickListener {
//                    countryName(data)
//                }
            }

        }

    }
    class MyViewHolder (itemView : View): RecyclerView.ViewHolder(itemView){
        val countryNameTV :TextView = itemView.findViewById(R.id.countryNameTV)
        val countryCodeTV :TextView = itemView.findViewById(R.id.countryCodeTV)
        val countryCL :ConstraintLayout = itemView.findViewById(R.id.constraintLayout)

    }
}