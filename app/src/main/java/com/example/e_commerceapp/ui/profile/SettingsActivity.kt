package com.example.e_commerceapp.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.ActivitySettingsBinding
import com.example.e_commerceapp.ui.address.AddNewAddressActivity
import com.example.e_commerceapp.ui.address.ShippingAddressActivity
import com.example.e_commerceapp.ui.payment.YourCardActivity

class SettingsActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySettingsBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding.addressCV.setOnClickListener {
            startActivity(Intent(this , AddNewAddressActivity::class.java))
        }
        binding.paymentCV.setOnClickListener { startActivity(Intent(this , YourCardActivity::class.java)) }
    }
}