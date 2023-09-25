package com.example.demoapp.di

import com.example.demoapp.Network.Service.GalleryService
import com.example.demoapp.Network.Service.ProductService
import com.example.demoapp.Utils.Constans.BASE_GALLARY
import com.example.demoapp.Utils.Constans.BASE_PRODUCT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ProductModule {

    @Singleton
    @Provides
    fun provideProductsRetrofit(): ProductService {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_PRODUCT)
            .build().create(ProductService::class.java)
    }


    @Singleton
    @Provides
    fun ProvidesGalleryApi(): GalleryService {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_GALLARY)
            .build().create(GalleryService::class.java)
    }

}
