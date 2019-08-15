package com.example.cars.carlist

import com.example.cars.entities.CarModel

class CarsMock {
    companion object {
        private val car1 = CarModel(
            id = 1,
            title = "car test 1",
            photoUrl = "/test/1"
        )
        private val car2 = CarModel(
            id = 2,
            title = "car test 2",
            photoUrl = "/test/2"
        )
        private val car3 = CarModel(
            id = 3,
            title = "car test 3",
            photoUrl = "/test/3"
        )
        private val car4 = CarModel(
            id = 4,
            title = "car test 4",
            photoUrl = "/test/4"
        )
        val cars = listOf(car1, car2, car3, car4)
    }
}