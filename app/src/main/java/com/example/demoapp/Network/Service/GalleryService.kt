package com.example.demoapp.Network.Service

import com.example.demoapp.Network.Models.GallaryResponse
import retrofit2.Response
import retrofit2.http.GET

interface GalleryService {
    @GET("/photos")
    fun getAllGalleryData(): Response<GallaryResponse>

}