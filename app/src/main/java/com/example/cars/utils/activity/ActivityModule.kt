package com.example.cars.utils.activity

import com.example.cars.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [])
    abstract fun contributeMainActivity(): MainActivity
}