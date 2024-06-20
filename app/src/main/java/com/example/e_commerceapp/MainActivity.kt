package com.example.e_commerceapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.e_commerceapp.ui.address.AddNewAddressActivity
import com.example.e_commerceapp.ui.auth.SignIn
import com.example.e_commerceapp.ui.filter.FilterActivity
import com.example.e_commerceapp.ui.home.HomeActivity
import com.example.e_commerceapp.ui.payment.AddNewCardActivity
import com.example.e_commerceapp.ui.payment.YourCardActivity
import com.example.e_commerceapp.ui.reviewRating.ReviewRatingActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        startActivity(Intent(this,  SignIn::class.java))
    }
}