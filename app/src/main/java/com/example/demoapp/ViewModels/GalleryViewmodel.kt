package com.example.demoapp.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoapp.Network.Models.GallaryResponse
import com.example.demoapp.Network.Models.HomeResponse
import com.example.demoapp.Repository.gallaryRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class GalleryViewmodel @Inject constructor(private val repository: gallaryRepository) :
    ViewModel() {
    val gallaryList: LiveData<GallaryResponse>
        get() = repository.gallaryData

    init {
        viewModelScope.launch {
            repository.getAllGallaryData()
        }
    }
}