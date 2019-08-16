package com.example.cars.utils.permissions

import android.Manifest
import androidx.fragment.app.Fragment
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import javax.inject.Inject

class PermissionChecker @Inject constructor() {
    private val compositeDisposable = CompositeDisposable()

    fun askForLocationPermissions(context: Fragment, success: () -> Unit, error: (String) -> Unit) {
        compositeDisposable += RxPermissions(context).request(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        ).subscribe({ granted ->
            if (granted) {
                success()
                compositeDisposable.clear()
            } else {
                error("Permission Not Granted!")
                compositeDisposable.clear()
            }
        }, {
            error(it.message ?: "Unexpected Error")
            compositeDisposable.clear()
        })
    }
}