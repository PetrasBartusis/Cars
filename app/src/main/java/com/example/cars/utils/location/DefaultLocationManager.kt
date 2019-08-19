package com.example.cars.utils.location

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import android.location.Location
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.Observable
import pl.charmas.android.reactivelocation2.ReactiveLocationProvider
import javax.inject.Inject

@SuppressLint("MissingPermission")
class DefaultLocationManager @Inject constructor(
    private val reactiveLocationProvider: ReactiveLocationProvider,
    private val rxPermissions: RxPermissions
): LocationManager {
    override fun getLastKnownLocation(): Observable<Location> =
        rxPermissions.request(
                ACCESS_FINE_LOCATION,
                ACCESS_COARSE_LOCATION
        ).flatMap { arePermissionsGranted ->
            if (arePermissionsGranted) {
                reactiveLocationProvider.lastKnownLocation
            } else {
                Observable.error(Exception("Location permissions not granted!"))
            }
        }
}