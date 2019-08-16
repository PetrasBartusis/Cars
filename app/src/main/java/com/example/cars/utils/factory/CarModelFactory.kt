package com.example.cars.utils.factory

import com.example.cars.entities.CarLocation
import com.example.cars.entities.CarModel
import com.example.cars.utils.network.entities.CarServiceModel
import javax.inject.Inject

class CarModelFactory @Inject constructor() {
    fun transformToCarModel(carServiceModel: CarServiceModel): CarModel {
        return CarModel(
            id = carServiceModel.id,
            title = carServiceModel.model?.title ?: "",
            photoUrl = carServiceModel.model?.photoUrl ?: "",
            location = CarLocation(
                id = carServiceModel.location.id,
                latitude = carServiceModel.location.latitude,
                longitude = carServiceModel.location.longitude,
                address = carServiceModel.location.address
            ),
            plateNumber = carServiceModel.plateNumber ?: "",
            remainingBattery = carServiceModel.batteryPrecentage ?: 0
        )
    }
}