package com.example.demoapp.di

import androidx.fragment.app.Fragment
import dagger.Component
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
@Component(dependencies = [ApplicationComponent::class])
interface FragmentComponent {
    fun inject(fragment: Fragment)
}