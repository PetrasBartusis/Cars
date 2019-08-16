package com.example.cars.utils.network

import com.example.cars.entities.CarModel
import com.example.cars.utils.factory.CarModelFactory
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class CarsService @Inject constructor(
        private val carsService: CarsApi,
        private val carModelFactory: CarModelFactory
) {
    @field:[Inject Named("io")]
    lateinit var ioScheduler: Scheduler

    fun getCarList(): Observable<List<CarModel>> {
        return carsService.getAvailableCars()
                .subscribeOn(ioScheduler)
                .map { carModelList ->
                    carModelList.map { carModelFactory.transformToCarModel(it) }
                }
    }
}