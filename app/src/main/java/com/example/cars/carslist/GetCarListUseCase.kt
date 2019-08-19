package com.example.cars.carslist

import android.location.Location
import com.example.cars.utils.filter.FilterOptions
import javax.inject.Inject

class GetCarListUseCase @Inject constructor(
        private val carRepository: CarRepository
) {
    fun getCarList() = carRepository.getCarList()

    fun getFilteredCarList(
            filterOptions: FilterOptions,
            location: Location
    ) = carRepository.getFilteredCarList(filterOptions, location)
}
