package com.example.e_commerceapp.ui.home.fragements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.FragmentCategoryKidsBinding
import com.example.e_commerceapp.ui.home.adapter.CategoryViewAdapter

class CategoryKidsFragment : Fragment() {

    private val binding by lazy { FragmentCategoryKidsBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.kidsRV.adapter = CategoryViewAdapter(requireContext() , getCategoryList())
    }

    companion object{
         fun getCategoryList() : ArrayList<String>{
            return ArrayList<String>().apply {
                add("T-shirt")
                add("Shorts")
                add("Jeans")
                add("Skirts")
                add("Trouser")
                add("Dresses")
                add("Sweater")
                add("Polo Shirt")
                add("Hooddies")
                add("Coats")
                add("Night Wear")
                add("Socks")
                add("Joggers")
                add("Baby Hat")
                add("Diapers")
            }
        }
    }

}