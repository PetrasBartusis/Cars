package com.example.cars.utils.network.entities

import com.google.gson.annotations.SerializedName


data class CarServiceModel(
        @SerializedName("id") val id: Int,
        @SerializedName("plateNumber") val plateNumber: String?,
        @SerializedName("location") val location: LocationServiceModel,
        @SerializedName("model") val model: ModelServiceModel?,
        @SerializedName("batteryPrecentage") val batteryPrecentage: Int?,
        @SerializedName("batteryEstimatedDistance") val batteryEstimatedDistance: Double?,
        @SerializedName("isCharging") val isCharging: Boolean?
)