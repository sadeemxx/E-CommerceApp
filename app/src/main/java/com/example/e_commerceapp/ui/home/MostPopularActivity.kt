package com.example.e_commerceapp.ui.home

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.ActivityMostPopularBinding
import com.example.e_commerceapp.ui.filter.FilterActivity
import com.example.e_commerceapp.ui.home.adapter.MostPopularAdapter
import com.example.e_commerceapp.utils.RightSpaceItemDecoration

class MostPopularActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMostPopularBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val spanCount = 2 // 2 columns
        binding.mostPopularRV.layoutManager = GridLayoutManager(this , spanCount)
//        binding.mostPopularRV.addItemDecoration(RightSpaceItemDecoration(150))
        binding.mostPopularRV.adapter = MostPopularAdapter()

        binding.filterIV.setOnClickListener { startActivity(Intent(this , FilterActivity::class.java)) }
    }
}