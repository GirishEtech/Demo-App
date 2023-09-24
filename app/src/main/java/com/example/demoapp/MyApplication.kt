package com.example.demoapp

import android.app.Application
import com.example.demoapp.di.ApplicationComponent
import com.example.demoapp.di.DaggerApplicationComponent
import dagger.Component
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication:Application(){
    lateinit var component:ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder().build()
    }
}
