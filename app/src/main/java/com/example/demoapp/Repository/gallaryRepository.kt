package com.example.demoapp.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demoapp.Network.Service.GalleryService
import com.example.demoapp.Network.Models.GallaryResponse
import com.example.demoapp.Network.Models.HomeResponse

class gallaryRepository(private val service: GalleryService) {
    private val _gallaryData = MutableLiveData<GallaryResponse>()
    val gallaryData: LiveData<GallaryResponse>
        get() = _gallaryData

    suspend fun getAllGallaryData() {
        val result = service.getAllGalleryData()
        if (result.isSuccessful && result.body() != null) {
            _gallaryData.postValue(result.body())
        }
    }
}