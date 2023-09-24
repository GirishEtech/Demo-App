package com.example.demoapp.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoapp.Network.Models.HomeResponse
import com.example.demoapp.Repository.productRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductviewModel @Inject constructor(private val repository: productRepository) :
    ViewModel() {

    val productList: LiveData<HomeResponse>
        get() = repository.prodcuts
    init {
        viewModelScope.launch {
            repository.getAllproducts()
        }
    }
}