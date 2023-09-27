package com.example.demoapp.ViewModels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoapp.Network.Models.HomeResponse
import com.example.demoapp.Network.Models.Product
import com.example.demoapp.Repository.productRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductviewModel @Inject constructor(private val repository: productRepository) :
    ViewModel() {

    val product: MutableLiveData<Any?>
        get() = repository.product

    val productList: LiveData<HomeResponse>
        get() = repository.prodcuts

    init {
        viewModelScope.launch {
            repository.getAllproducts()
        }
    }

    fun getProductbyId(id: Int) {
        viewModelScope.launch {
            repository.getProduct(id)
        }

    }
}