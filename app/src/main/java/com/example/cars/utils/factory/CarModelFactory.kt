package com.example.cars.utils.factory

import com.example.cars.entities.CarModel
import com.example.cars.utils.network.entities.CarServiceModel
import javax.inject.Inject

class CarModelFactory @Inject constructor() {
    fun transformToCarModel(carServiceModel: CarServiceModel): CarModel {
        return CarModel(
                id = carServiceModel.id,
                title = carServiceModel.model?.title ?: "",
                photoUrl = carServiceModel.model?.photoUrl ?: ""
        )
    }
}