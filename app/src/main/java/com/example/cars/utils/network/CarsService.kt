package com.example.cars.utils.network

import com.example.cars.utils.network.entities.CarServiceModel
import io.reactivex.Observable
import retrofit2.http.GET

interface CarsService {
    @GET("api/mobile/public/availablecars")
    fun getAvailableCars(): Observable<List<CarServiceModel>>
}