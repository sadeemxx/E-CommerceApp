package com.example.e_commerceapp.ui.filter

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.ViewDebug.IntToString
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.ActivityFilterBinding

class FilterActivity : AppCompatActivity() {

    private val binding by lazy { ActivityFilterBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        binding.priceRS.addOnChangeListener{ slider,value, fromUser ->
            val values = slider.values

            val minPrice = values[0]
            val maxPrice = values[1]
            binding.minPriceTV.text = "$ ${minPrice}"
            binding.maxPriceTV.text = "$ ${maxPrice}"

        }

        binding.colorRV.adapter = FilterColorAdapter(this , getColorsList()){ clickedColor ->
            Toast.makeText(this, clickedColor, Toast.LENGTH_SHORT).show()
            val colorInt = Color.parseColor(clickedColor)
            binding.priceRS.apply {
                thumbStrokeColor = ColorStateList.valueOf(colorInt)
                trackActiveTintList = ColorStateList.valueOf(colorInt)
                haloTintList = ColorStateList.valueOf(colorInt)
                thumbTintList = ColorStateList.valueOf(colorInt)
            }
        }
    }
    private fun getColorsList():ArrayList<String>{
        return arrayListOf(
            "#C4B5B1",
            "#ECDFBD",
            "#FFD5DF",
            "#DDDAD0",
            "#B3E2E5",
            "#DFC6C7"
        )
    }
}