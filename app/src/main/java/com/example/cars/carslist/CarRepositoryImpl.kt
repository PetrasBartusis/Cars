package com.example.cars.carslist

import com.example.cars.entities.CarModel
import com.example.cars.utils.factory.CarModelFactory
import com.example.cars.utils.network.CarsService
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class CarRepositoryImpl @Inject constructor(
        private val carsService: CarsService,
        private val carModelFactory: CarModelFactory
): CarRepository {
    @field:[Inject Named("io")]
    lateinit var ioScheduler: Scheduler

    override fun getCarList(): Observable<List<CarModel>> {
        return carsService.getAvailableCars()
                .subscribeOn(ioScheduler)
                .map { carModelList ->
            carModelList.map { carModelFactory.transformToCarModel(it) }
        }
    }
}