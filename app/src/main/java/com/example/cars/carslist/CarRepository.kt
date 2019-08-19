package com.example.cars.carslist

import android.location.Location
import com.example.cars.entities.CarModel
import com.example.cars.utils.filter.FilterOptions
import io.reactivex.Observable

interface CarRepository {
    fun getCarList(): Observable<List<CarModel>>

    fun getFilteredCarList(filterOptions: FilterOptions, location: Location): Observable<List<CarModel>>
}
