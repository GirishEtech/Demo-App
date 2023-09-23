package com.example.demoapp.di

import com.example.demoapp.Network.Service.ProductService
import com.example.demoapp.Utils.Constans.BASE_PRODUCT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ProductModule {

    @Singleton
    @Provides
    fun provideProductsRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_PRODUCT)
            .build()
    }

    @Singleton
    @Provides
    fun ProvidesProductApi(productRetorfit: Retrofit): ProductService {
        return productRetorfit.create(ProductService::class.java)
    }
}
