package com.example.demoapp.Network.Service

import com.example.demoapp.Network.Models.HomeResponse
import com.example.demoapp.Network.Models.Product
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {
    @GET("/products")
    suspend fun getAllProducts(): Response<HomeResponse>

    @GET("/products/{id}")
    fun getUser(@Path("id") id: Int): Response<Product>?
}