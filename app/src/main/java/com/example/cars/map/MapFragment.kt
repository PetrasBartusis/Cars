package com.example.cars.map

import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cars.R
import com.example.cars.utils.activity.openDrawer
import com.example.cars.utils.activity.showMessage
import com.example.cars.utils.fragment.BaseFragment
import com.example.cars.utils.permissions.PermissionChecker
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_cars_map.*
import javax.inject.Inject


class MapFragment : BaseFragment() {
    override val layoutRes = R.layout.fragment_cars_map

    @Inject
    lateinit var permissionChecker: PermissionChecker

    private val viewModel: MapViewModel by lazy {
        ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(MapViewModel::class.java)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mapView.onCreate(savedInstanceState)
        requestLocationPermissions()
        viewModel.showMessage().observe(this, Observer { message ->
            activity?.showMessage(message)
        })
        viewModel.zoomListener().observe(this, Observer { location ->
            zoomToLocation(location)
        })
    }

    private fun requestLocationPermissions() {
        permissionChecker.askForLocationPermissions(
            this,
            success = {
                setUpMap()
            },
            error = {
                activity?.showMessage(it)
            }
        )
    }

    private fun zoomToLocation(location: Location) {
        mapView.getMapAsync { googleMap ->
            googleMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(
                    LatLng(location.latitude, location.longitude),
                    8f
                )
            )
        }
    }

    @SuppressLint("MissingPermission")
    private fun setUpMap() {
        mapView.getMapAsync { googleMap ->
            googleMap.isMyLocationEnabled = true
            viewModel.getCars().observe(this, Observer { cars ->
                cars.forEach { car ->
                    googleMap.addMarker(
                        MarkerOptions().title(car.title)
                            .draggable(false)
                            .position(car.location.toLatLng())
                    )
                }
            })
        }
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
        viewModel.onAttach()
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onPause() {
        mapView.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        if (mapView != null) {
            mapView.onDestroy()
        }
        super.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}