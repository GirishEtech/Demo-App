package com.example.demoapp.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoapp.Repository.productRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductviewModel @Inject constructor(private val repository: productRepository):ViewModel() {

    fun getAllproducts()
    {
        viewModelScope.launch {
            repository.getAllproducts()
        }
    }
}