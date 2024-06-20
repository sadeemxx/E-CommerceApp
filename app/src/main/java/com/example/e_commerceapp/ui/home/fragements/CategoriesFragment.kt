package com.example.e_commerceapp.ui.home.fragements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.FragmentCategoriesBinding
import com.example.e_commerceapp.ui.home.adapter.CategoryViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class CategoriesFragment : Fragment() {

    private val binding  by lazy { FragmentCategoriesBinding.inflate(layoutInflater) }

    // Define an ArrayList of tab titles
    private val tabTitles = arrayListOf("Women", "Men", "Kids")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.categoryVP.adapter = CategoryViewPagerAdapter(requireActivity())
        TabLayoutMediator(binding.categoryTL , binding.categoryVP){ tab ,position  ->
            tab.text = tabTitles[position]
        }.attach()

    }
}