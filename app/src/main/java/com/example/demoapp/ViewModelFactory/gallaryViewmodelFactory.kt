package com.example.demoapp.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.demoapp.Repository.gallaryRepository
import com.example.demoapp.ViewModels.GalleryViewmodel
import javax.inject.Inject

class gallaryViewmodelFactory @Inject constructor(private val repository: gallaryRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GalleryViewmodel(repository) as T
    }
}