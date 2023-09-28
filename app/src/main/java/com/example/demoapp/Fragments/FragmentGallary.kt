package com.example.demoapp.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.demoapp.Adapters.GallaryAdapter
import com.example.demoapp.MyApplication
import com.example.demoapp.R
import com.example.demoapp.Utils.Constans
import com.example.demoapp.ViewModelFactory.gallaryViewmodelFactory
import com.example.demoapp.ViewModels.GalleryViewmodel
import com.example.demoapp.databinding.FragmentGallaryBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentGallary : Fragment(), GallaryAdapter.communication {

    lateinit var viewModel: GalleryViewmodel
    lateinit var adapter: GallaryAdapter

    @Inject
    lateinit var factory: gallaryViewmodelFactory

    lateinit var _binding: FragmentGallaryBinding
    private val binding: FragmentGallaryBinding
        get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGallaryBinding.inflate(inflater, container, false)
        (requireActivity().application as MyApplication).component.inject(requireActivity())
        initData()
        return binding.root
    }

    private fun initData() {
        try {

            viewModel = ViewModelProvider(this, factory)[GalleryViewmodel::class.java]
            viewModel.isLoading.observe(viewLifecycleOwner) {
                if (it) {
                    binding.Loading.visibility = View.VISIBLE
                } else {
                    binding.Loading.visibility = View.INVISIBLE
                }
            }

            viewModel.gallaryList.observe(viewLifecycleOwner) {
                adapter = GallaryAdapter(this, it)
                binding.gallaryList.adapter = adapter
            }
        } catch (ex: Exception) {
            Toast.makeText(requireContext(), "${ex.message}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun passImage(image: String) {
        val fragment = FragmentGallaryDetail()
        val bundle = Bundle()
        bundle.putString("imgUrl", image)
        fragment.arguments = bundle
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView2, fragment, "fragmentGalleryDetail")
        transaction.addToBackStack("fragmentGalleryDetail")
        transaction.commit()
    }

}