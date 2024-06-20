package com.example.e_commerceapp.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.ActivitySignInBinding
import com.example.e_commerceapp.ui.home.HomeActivity

class SignIn : AppCompatActivity() {
    private val binding by lazy { ActivitySignInBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        binding.btnLogin.setOnClickListener { startActivity(Intent(this , HomeActivity::class.java)) }
        binding.forgetPasswordTV.setOnClickListener { startActivity(Intent(this , ForgetPassword::class.java)) }
        binding.signUpTV.setOnClickListener { startActivity(Intent(this , SignUp::class.java)) }


    }
}