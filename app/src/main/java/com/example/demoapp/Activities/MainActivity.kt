package com.example.demoapp.Activities

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.demoapp.Fragments.FragmentGallary
import com.example.demoapp.Fragments.FragmentHome
import com.example.demoapp.Fragments.FragmentTodo
import com.example.demoapp.R
import com.example.demoapp.databinding.ActivityMainBinding
import com.google.android.material.appbar.MaterialToolbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    private val binding: ActivityMainBinding
        get() = _binding

    private var actionBar:MaterialToolbar?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponents()
    }

    private fun initComponents() {
        initNavigation()
        actionBar = binding.toolbar
        setSupportActionBar(actionBar)
        loadFragment(FragmentHome(), "HomeFragment")
    }


    private fun initNavigation() {
        binding.ButtomNavigation.setOnItemSelectedListener {
            val transaction = supportFragmentManager.beginTransaction()
            when (it.itemId) {
                R.id.buttom_home -> {
                    showFragment(transaction, "HomeFragment")
                    actionBar!!.title = "Product List"
                }

                R.id.buttom_gallary -> {
                    showFragment(transaction, "GalleryFragment")
                    actionBar!!.title = "Gallery"
                }

                R.id.buttom_todo -> {
                    showFragment(transaction, "ToDoFragment")
                    actionBar!!.title = "Todo"

                }
            }
            true
        }
    }


    private fun loadFragment(fragment: Fragment, tag: String) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView2, fragment, tag)
        transaction.addToBackStack(null) // Add to back stack
        transaction.commit()
    }

    private fun showFragment(transaction: FragmentTransaction, tag: String) {
        var fragment = supportFragmentManager.findFragmentByTag(tag)
        if (fragment != null) {
            // Fragment already exists, just show it
            transaction.show(fragment)
        } else {
            // Fragment doesn't exist, create and add it
            if (tag == "HomeFragment") {
                fragment = FragmentHome()
            } else if (tag == "GalleryFragment") {
                fragment = FragmentGallary()
            } else if (tag == "ToDoFragment") {
                fragment = FragmentTodo()
            }
            transaction.add(R.id.fragmentContainerView2, fragment!!, tag)
        }

        // Hide other fragments
        if (fragment != null) {
            if (fragment.tag.equals("HomeFragment")) {
                hideFragment(transaction, "GalleryFragment")
                hideFragment(transaction, "ToDoFragment")
            } else if (fragment.tag.equals("GalleryFragment")) {
                hideFragment(transaction, "HomeFragment")
                hideFragment(transaction, "ToDoFragment")
            } else if (fragment.tag.equals("ToDoFragment")) {
                hideFragment(transaction, "HomeFragment")
                hideFragment(transaction, "GalleryFragment")
            }
        }
        transaction.commit()
    }

    private fun hideFragment(transaction: FragmentTransaction, tag: String) {
        val fragment: Fragment? = supportFragmentManager.findFragmentByTag(tag)
        if (fragment != null) {
            transaction.hide(fragment)
        }
    }


}