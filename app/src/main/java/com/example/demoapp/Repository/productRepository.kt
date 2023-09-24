package com.example.demoapp.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demoapp.Network.Models.HomeResponse
import com.example.demoapp.Network.Service.ProductService
import javax.inject.Inject

class productRepository @Inject constructor(private val productService: ProductService) {

    private val _products = MutableLiveData<HomeResponse>()
    val prodcuts: LiveData<HomeResponse>
        get() = _products

    suspend fun getAllproducts() {
        val result = productService.getAllProducts()
        if (result.isSuccessful && result.body() != null) {
            _products.postValue(result.body())
        }
    }
}