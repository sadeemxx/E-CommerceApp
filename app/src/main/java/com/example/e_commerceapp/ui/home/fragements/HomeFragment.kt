package com.example.e_commerceapp.ui.home.fragements

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.FragmentHomeBinding
import com.example.e_commerceapp.ui.home.MostPopularActivity
import com.example.e_commerceapp.ui.home.adapter.ForYouAdapter
import com.example.e_commerceapp.ui.home.adapter.ListButtonAdapter
import com.example.e_commerceapp.ui.home.adapter.MostPopularAdapter
import com.example.e_commerceapp.ui.profile.ProfileActivity
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mostPopularRV.adapter = MostPopularAdapter()

        binding.listButtonRV.adapter = ListButtonAdapter(requireContext() , getButtonList()){clickedButtonName ->
            Toast.makeText(requireContext(), clickedButtonName, Toast.LENGTH_SHORT).show()

        }

        binding.profileIV.setOnClickListener {
            startActivity(Intent(requireContext() , ProfileActivity::class.java))
        }

        binding.forYouRV.adapter = ForYouAdapter()
        binding.seeAllTV.setOnClickListener { startActivity(Intent(requireContext() , MostPopularActivity::class.java)) }
    }
    private fun getButtonList():ArrayList<String>{
        return ArrayList<String>().apply {
            add("All")
            add("Women Bag")
            add("Women Clothes")
            add("Men")
            add("Men T Shirt")
            add("Men Supports")
            add("Kids")
            add("Summer")
            add("Winter")
            add("Sales")
            add("Salesd,jfhsdjk")
        }
    }
}