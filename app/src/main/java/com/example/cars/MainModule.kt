package com.example.cars

import com.example.cars.carslist.CarListFragment
import com.example.cars.carslist.CarListModule
import com.example.cars.map.MapFragment
import com.example.cars.map.MapModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule private constructor() {
    @ContributesAndroidInjector(modules = [CarListModule::class])
    abstract fun contributesCarListFragment(): CarListFragment

    @ContributesAndroidInjector(modules = [MapModule::class])
    abstract fun contributesMapFragment(): MapFragment
}