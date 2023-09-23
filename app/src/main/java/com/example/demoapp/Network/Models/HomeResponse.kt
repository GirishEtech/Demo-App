package com.example.demoapp.Network.Models

data class HomeResponse(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)