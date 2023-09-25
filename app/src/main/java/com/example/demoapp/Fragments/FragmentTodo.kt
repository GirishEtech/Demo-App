package com.example.demoapp.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.demoapp.R
import com.example.demoapp.databinding.FragmentTodoBinding

class FragmentTodo : Fragment() {

    lateinit var _binding: FragmentTodoBinding
    private val binding: FragmentTodoBinding
        get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }


}