package com.example.demoapp.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demoapp.Network.Models.HomeResponse
import com.example.demoapp.Network.Models.Product
import com.example.demoapp.Network.Service.ProductService
import retrofit2.Response
import javax.inject.Inject

class productRepository @Inject constructor(private val productService: ProductService) {

    private val _product = MutableLiveData<Any?>()
     val product: MutableLiveData<Any?>
        get () = _product
    private val _products = MutableLiveData<HomeResponse>()
    val prodcuts: LiveData<HomeResponse>
        get() = _products

    suspend fun getAllproducts() {
        val result = productService.getAllProducts()
        if (result.isSuccessful && result.body() != null) {
            _products.postValue(result.body())
        }
    }
   suspend fun getProduct(id:Int)
    {
        val result = productService.getProductById(id)
        if (result.isSuccessful && result.body() != null){
            _product.postValue(result.body())
        }
    }
}