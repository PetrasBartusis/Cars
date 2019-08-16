package com.example.cars.map

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

    fun getCars() = carList

    fun showMessage() = showMessage

    fun onAttach() {
        compositeDisposable += getCarListUseCase.getCarList().subscribe({
            carList.postValue(it)
        }, {
            showMessage.postValue(it.message)
        })
    }
}