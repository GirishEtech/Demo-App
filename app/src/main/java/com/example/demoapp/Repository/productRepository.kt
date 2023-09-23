package com.example.demoapp.Repository

import android.util.Log
import com.example.demoapp.Network.Models.HomeResponse
import com.example.demoapp.Network.Service.ProductService
import com.example.demoapp.Utils.Constans
import javax.inject.Inject

class productRepository @Inject constructor(private val productService: ProductService) {

    suspend fun getAllproducts() {
        val response = productService.getAllProducts()
        Log.d(Constans.TAG, "${response.body()}")
    }
}