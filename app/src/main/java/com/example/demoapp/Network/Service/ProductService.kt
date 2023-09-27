package com.example.demoapp.Network.Service

import com.example.demoapp.Network.Models.HomeResponse
import com.example.demoapp.Network.Models.Product
import com.example.demoapp.Network.Models.ProductResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ProductService {

    @GET("/products")
    suspend fun getAllProducts(): Response<HomeResponse>

    @GET("/products/{productId}")
    suspend fun getProductById(@Path("productId") productId: Int): Response<ProductResponse>

}