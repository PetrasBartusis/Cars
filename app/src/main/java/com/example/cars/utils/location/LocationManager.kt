package com.example.cars.utils.location

import android.location.Location
import io.reactivex.Observable

interface LocationManager {
    fun getLastKnownLocation(): Observable<Location>
}
