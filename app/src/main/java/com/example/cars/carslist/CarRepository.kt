package com.example.cars.carslist

import com.example.cars.entities.CarModel
import io.reactivex.Observable

interface CarRepository {
    fun getCarList(): Observable<List<CarModel>>
}
