package com.example.cars.entities

data class CarModel (
    val id : Int,
    val title : String,
    val photoUrl : String,
    val location: CarLocation,
    val plateNumber: String,
    val remainingBattery: Int
)