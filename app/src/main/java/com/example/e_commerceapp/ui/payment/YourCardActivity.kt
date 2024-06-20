package com.example.e_commerceapp.ui.payment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.e_commerceapp.R
import com.example.e_commerceapp.data.model.CardModel
import com.example.e_commerceapp.databinding.ActivityYourCardBinding
import com.example.e_commerceapp.ui.address.adapter.GenaricAdapter

class YourCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityYourCardBinding.inflate(layoutInflater) }

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        setUpRV()
        binding.addCardCV.setOnClickListener { startActivity(Intent(this , PaymentMethodActivity::class.java)) }

    }

    private fun setUpRV() {
        val bindingInterface = object : GenaricAdapter.GenaricAdapterInterface<CardModel>{
            override fun bindData(item: CardModel, view: View) {
                val cardNameTV : TextView = view.findViewById(R.id.masterCardTV)
                val cardNoTV : TextView = view.findViewById(R.id.cardNumberTV)
                val cardHolderNameTV : TextView = view.findViewById(R.id.cardHolderNameTV)
                val cardExpiryTV : TextView = view.findViewById(R.id.expiryDateTV)

                cardNameTV.text = item.cardName
                cardNoTV.text = item.cardNo
                cardHolderNameTV.text = item.cardHolderName
                cardExpiryTV.text = item.cardExpiry
            }

        }

        val adapter = GenaricAdapter<CardModel>(CardData.cards , R.layout.item_cards , bindingInterface){

        }
        binding.cardRV.adapter = adapter
    }
    object CardData{
        val cards : List<CardModel> by lazy {
            listOf(
            CardModel("Master Card" , "1234 4567 7897 5645", "Faizan javed" , "12/12"),
            CardModel("Master Card" , "1234 4567 7897 5645", "Faizan javed" , "12/12"),
            CardModel("Universal" , "1234 4567 7897 5645", "Faizan javed" , "12/12")
            )
        }
    }
}