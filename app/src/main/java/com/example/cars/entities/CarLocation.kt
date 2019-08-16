package com.example.cars.entities

import android.location.Location
import android.location.LocationManager
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

    fun toLocation(): Location? {
        return Location(LocationManager.GPS_PROVIDER).apply{
            latitude = this@CarLocation.latitude ?: 0.0
            longitude = this@CarLocation.longitude ?: 0.0
        }
    }
}