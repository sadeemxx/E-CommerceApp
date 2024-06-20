package com.example.e_commerceapp.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.e_commerceapp.ui.home.fragements.CategoryKidsFragment
import com.example.e_commerceapp.ui.home.fragements.CategoryMenFragment
import com.example.e_commerceapp.ui.home.fragements.CategoryWomenFragment

class CategoryViewPagerAdapter (fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CategoryWomenFragment()
            1 -> CategoryMenFragment()
            2 -> CategoryKidsFragment()
            else -> throw IllegalAccessException()
        }
    }

}