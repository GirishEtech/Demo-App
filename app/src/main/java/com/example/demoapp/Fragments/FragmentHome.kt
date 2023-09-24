package com.example.demoapp.Fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.demoapp.Adapters.ProductAdapter
import com.example.demoapp.MyApplication
import com.example.demoapp.Utils.Constans
import com.example.demoapp.ViewModelFactory.MainViewmodelFactory
import com.example.demoapp.ViewModels.ProductviewModel
import com.example.demoapp.databinding.FragmentHomeBinding
import com.example.demoapp.di.DaggerFragmentComponent
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentHome : Fragment() {

    lateinit var viewModel: ProductviewModel
    lateinit var adapter: ProductAdapter

    @Inject
    lateinit var viewModelFactory: MainViewmodelFactory

    lateinit var _binding: FragmentHomeBinding
    private val binding: FragmentHomeBinding
        get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        (requireActivity().application as MyApplication).component.inject(requireActivity())
        viewModel = ViewModelProvider(this, viewModelFactory)[ProductviewModel::class.java]
        viewModel.productList.observe(viewLifecycleOwner) {

            try {
                Log.d(Constans.TAG, it.products.toString())
                adapter = ProductAdapter(it.products)
                binding.productList.adapter = adapter
            } catch (ex: Exception) {
                Toast.makeText(requireContext(), ex.message.toString(), Toast.LENGTH_SHORT)
                    .show()
            }
        }

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragmentComponent = DaggerFragmentComponent.builder()
            .applicationComponent((requireActivity().application as MyApplication).component)
            .build()
        fragmentComponent.inject(this)
    }
}