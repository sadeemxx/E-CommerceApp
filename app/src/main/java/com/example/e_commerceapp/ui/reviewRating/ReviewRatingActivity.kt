package com.example.e_commerceapp.ui.reviewRating

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.ActivityReviewRatingBinding
import com.example.e_commerceapp.utils.ReviewRatingBottomSheet

class ReviewRatingActivity : AppCompatActivity() {

    private val binding by lazy { ActivityReviewRatingBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding.btnReview.setOnClickListener {
            val modal = ReviewRatingBottomSheet()
            supportFragmentManager.let { modal.show(it , "") }
        }


    }
}