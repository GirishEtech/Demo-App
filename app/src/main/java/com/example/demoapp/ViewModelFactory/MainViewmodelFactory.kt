package com.example.demoapp.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.demoapp.Repository.productRepository
import com.example.demoapp.ViewModels.ProductviewModel
import javax.inject.Inject

class MainViewmodelFactory @Inject constructor(private val repository: productRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductviewModel(repository) as T
    }
}