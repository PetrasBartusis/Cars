package com.example.cars

import com.example.cars.carslist.CarListFragment
import com.example.cars.carslist.CarListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule private constructor() {
    @ContributesAndroidInjector(modules = [CarListModule::class])
    abstract fun contributesCarListFragment(): CarListFragment
}