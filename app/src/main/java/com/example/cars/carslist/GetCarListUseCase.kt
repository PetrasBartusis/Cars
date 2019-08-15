package com.example.cars.carslist

import javax.inject.Inject

class GetCarListUseCase @Inject constructor(
        private val carRepository: CarRepository
) {
    fun getCarList() = carRepository.getCarList()
}
