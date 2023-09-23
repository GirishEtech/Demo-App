package com.example.demoapp.Network.Service

import com.example.demoapp.Network.Models.GallaryResponse
import retrofit2.Call
import retrofit2.http.GET

interface GallaryService {
    @GET("/photos")
    suspend fun getGallaryData(): Call<GallaryResponse>
}