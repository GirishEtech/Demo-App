package com.example.demoapp.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.demoapp.R
import com.example.demoapp.databinding.FragmentGallaryDetailBinding


class FragmentGallaryDetail : Fragment() {

    lateinit var _binding: FragmentGallaryDetailBinding
    val binding: FragmentGallaryDetailBinding
        get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGallaryDetailBinding.inflate(inflater, container, false)
        val imageUrl = arguments?.getString("imgUrl")
        Glide.with(this).load(imageUrl).into(binding.gallaryDetailImage)
        return binding.root
    }


}