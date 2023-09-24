package com.example.demoapp.di

import androidx.fragment.app.FragmentActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ProductModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: FragmentActivity)
}