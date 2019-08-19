package com.example.cars.carslist

import android.location.Location
import com.example.cars.entities.CarModel
import com.example.cars.utils.filter.CarFilter
import com.example.cars.utils.filter.FilterOptions
import com.example.cars.utils.network.CarsService
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class CarRepositoryImpl @Inject constructor(
        private val carsService: CarsService,
        private val carFilter: CarFilter
) : CarRepository {
    @field:[Inject Named("io")]
    lateinit var ioScheduler: Scheduler

    override fun getCarList(): Observable<List<CarModel>> {
        return carsService.getCarList()
    }

    override fun getFilteredCarList(filterOptions: FilterOptions, location: Location): Observable<List<CarModel>> {
        return carsService.getCarList().map { carList ->
            val filteredCars = carFilter.filterList(carList, filterOptions)
            if (filterOptions.distanceFilter) {
                carFilter.sortByDistance(filteredCars, location)
            } else {
                filteredCars
            }
        }
    }
}