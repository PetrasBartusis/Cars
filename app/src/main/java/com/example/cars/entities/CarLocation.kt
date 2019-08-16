package com.example.cars.entities

import com.google.android.gms.maps.model.LatLng

data class CarLocation(
    val id : Int?,
    val latitude : Double?,
    val longitude : Double?,
    val address : String?
) {
    fun toLatLng(): LatLng {
        return LatLng(latitude ?: 0.0, longitude ?: 0.0)
    }
}