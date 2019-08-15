package com.example.cars.utils.storage

import com.example.cars.carslist.CarRepository
import com.example.cars.carslist.CarRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoriesModule private constructor() {
    @Binds
    abstract fun bindCarsRepository(carsRepository: CarRepositoryImpl): CarRepository
}