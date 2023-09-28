package com.example.demoapp.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoapp.Network.Models.GallaryRespose
import com.example.demoapp.Repository.gallaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GalleryViewmodel @Inject constructor(private val repository: gallaryRepository) :
    ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val gallaryList: LiveData<GallaryRespose>
        get() = repository.gallaryData

    init {
        isLoading.value = true
        viewModelScope.launch {
            repository.getAllproducts()
            isLoading.value = false
        }
    }
}