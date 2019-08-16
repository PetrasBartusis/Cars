package com.example.cars.carlist

import com.example.cars.entities.CarLocation
import com.example.cars.entities.CarModel
import com.example.cars.utils.network.entities.CarServiceModel
import com.example.cars.utils.network.entities.LocationServiceModel
import com.example.cars.utils.network.entities.ModelServiceModel
import com.example.cars.utils.network.entities.RateServiceModel

class CarsMock {
    companion object {
        private val car1 = CarModel(
            id = 1,
            title = "car test 1",
            photoUrl = "/test/1",
            location = CarLocation(
                id = 1,
                address = "test 1",
                longitude = 1.0,
                latitude = 1.0
            )
        )
        private val car2 = CarModel(
            id = 2,
            title = "car test 2",
            photoUrl = "/test/2",
            location = CarLocation(
                id = 2,
                address = "test 2",
                longitude = 2.0,
                latitude = 2.0
            )
        )
        private val car3 = CarModel(
            id = 3,
            title = "car test 3",
            photoUrl = "/test/3",
            location = CarLocation(
                id = 3,
                address = "test 3",
                longitude = 3.0,
                latitude = 3.0
            )
        )
        private val car4 = CarModel(
            id = 4,
            title = "car test 4",
            photoUrl = "/test/4",
            location = CarLocation(
                id = 4,
                address = "test 4",
                longitude = 4.0,
                latitude = 4.0
            )
        )
        val cars = listOf(car1, car2, car3, car4)
    }
}