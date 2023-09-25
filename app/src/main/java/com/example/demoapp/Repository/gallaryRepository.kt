package com.example.demoapp.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demoapp.Network.Models.GallaryRespose
import com.example.demoapp.Network.Service.GalleryService
import javax.inject.Inject

class gallaryRepository @Inject constructor(private val service: GalleryService) {
    private val _gallaryData = MutableLiveData<GallaryRespose>()
    val gallaryData: LiveData<GallaryRespose>
        get() = _gallaryData

    suspend fun getAllproducts() {
        val result = service.getAllGalleryData()
        if (result.isSuccessful && result.body() != null) {
            _gallaryData.postValue(result.body())
        }
    }
}