package com.example.cars.utils.network

import io.reactivex.Observable
import retrofit2.http.GET
import com.example.cars.utils.network.entities.CarModel

interface CarsService {
    @GET("api/mobile/public/availablecars")
    fun getAvailableCars(): Observable<List<CarModel>>
}