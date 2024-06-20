package com.example.e_commerceapp.ui.home.fragements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.FragmentMyCartBinding
import com.example.e_commerceapp.ui.home.adapter.MyCartAdapter

class MyCartFragment : Fragment() {

    private val binding by lazy { FragmentMyCartBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myCartRV.adapter = MyCartAdapter()
    }
}