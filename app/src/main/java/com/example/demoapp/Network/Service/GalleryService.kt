package com.example.demoapp.Network.Service

import com.example.demoapp.Network.Models.GallaryRespose
import retrofit2.Response
import retrofit2.http.GET

interface GalleryService {
    @GET("/photos")
    suspend fun getAllGalleryData(): Response<GallaryRespose>
}