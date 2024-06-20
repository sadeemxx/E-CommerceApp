package com.example.e_commerceapp.ui.home.fragements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.FragmentFavouriteItemBinding
import com.example.e_commerceapp.ui.home.adapter.ListButtonAdapter
import com.example.e_commerceapp.ui.home.adapter.SavedItemAdapter

class FavouriteItemFragment : Fragment() {

    private val binding by lazy { FragmentFavouriteItemBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveItemButtonsRV.adapter = ListButtonAdapter(requireContext() , getButtonList()){

        }

        binding.savedItemsRV.adapter = SavedItemAdapter()

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