package com.example.demoapp.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.demoapp.MyApplication
import com.example.demoapp.Network.Models.ProductResponse
import com.example.demoapp.Utils.Constans
import com.example.demoapp.ViewModels.ProductviewModel
import com.example.demoapp.databinding.FragmentProductDetailBinding

class FragmentDetail : Fragment() {

    val viewModel: ProductviewModel by activityViewModels()

    lateinit var _binding: FragmentProductDetailBinding
    private val binding: FragmentProductDetailBinding
        get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        val id = arguments?.getInt("p_id")!!
        viewModel.getProductbyId(id)
        Log.d("DEBUG","id :$id")
        viewModel.product.observe(viewLifecycleOwner) {
            try {
                binding.titleDetails.text =(it as ProductResponse).title
                binding.subTitleDetails.text = it.description
                Glide.with(this).load(it.thumbnail).into(binding.productImageDetail)
            } catch (ex: Exception) {
                Toast.makeText(requireContext(), ex.message.toString(), Toast.LENGTH_SHORT)
                    .show()
            }
        }

        return binding.root
    }


}