package com.example.cars.map

import android.location.Location
import androidx.lifecycle.MutableLiveData
import com.example.cars.carslist.GetCarListUseCase
import com.example.cars.entities.CarModel
import com.example.cars.utils.viewmodel.BaseViewModel
import io.reactivex.rxkotlin.plusAssign
import javax.inject.Inject

class MapViewModel @Inject constructor(
        private val getCarListUseCase: GetCarListUseCase
): BaseViewModel() {
    private val carList = MutableLiveData<List<CarModel>>()
    private val showMessage = MutableLiveData<String>()
    private val zoomListener = MutableLiveData<Location>()

    fun getCars() = carList

    fun showMessage() = showMessage

    fun zoomListener() = zoomListener

    fun onAttach() {
        compositeDisposable += getCarListUseCase.getCarList().subscribe({ cars ->
            carList.postValue(cars)
            zoomListener.postValue(cars[0].location.toLocation())
        }, {
            showMessage.postValue(it.message)
        })
    }
}