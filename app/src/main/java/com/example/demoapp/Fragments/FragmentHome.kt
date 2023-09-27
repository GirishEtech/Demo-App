package com.example.demoapp.Fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.demoapp.Adapters.ProductAdapter
import com.example.demoapp.MyApplication
import com.example.demoapp.R
import com.example.demoapp.Utils.Constans
import com.example.demoapp.ViewModels.ProductviewModel
import com.example.demoapp.databinding.FragmentHomeBinding
import com.example.demoapp.di.DaggerFragmentComponent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHome : Fragment(),ProductAdapter.communication{

    val viewModel: ProductviewModel by activityViewModels()
    lateinit var adapter: ProductAdapter

    lateinit var _binding: FragmentHomeBinding
    private val binding: FragmentHomeBinding
        get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel.productList.observe(viewLifecycleOwner) {
            try {
                Log.d(Constans.TAG, it.products.toString())
                adapter = ProductAdapter(this,it.products)
                binding.productList.adapter = adapter
            } catch (ex: Exception) {
                Toast.makeText(requireContext(), ex.message.toString(), Toast.LENGTH_SHORT)
                    .show()
            }
        }

        return binding.root
    }

    override fun passid(id: Int) {
        val fragment = FragmentDetail()
        val bundle = Bundle()
        bundle.putInt("p_id",id)
        fragment.arguments = bundle
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView2, fragment, "fragmentDetail")
        transaction.addToBackStack("fragmentDetail")
        transaction.commit()
    }
}