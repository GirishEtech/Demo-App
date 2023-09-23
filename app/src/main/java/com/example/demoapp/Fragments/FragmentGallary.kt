package com.example.demoapp.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.demoapp.R


class FragmentGallary : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(requireContext(), "Fragment Gallery", Toast.LENGTH_SHORT).show()
        return inflater.inflate(R.layout.fragment_gallary, container, false)
    }

}