package com.example.demoapp.Network.Models

data class GallaryResponseItem(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)