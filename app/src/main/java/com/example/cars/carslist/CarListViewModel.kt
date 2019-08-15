package com.example.cars.carslist

import androidx.lifecycle.MutableLiveData
import com.example.cars.entities.CarModel
import com.example.cars.utils.viewmodel.BaseViewModel
import io.reactivex.rxkotlin.plusAssign
import javax.inject.Inject

class CarListViewModel @Inject constructor(
    private val getCarListUseCase: GetCarListUseCase
): BaseViewModel() {
    private val carList = MutableLiveData<List<CarModel>>()
    private val errorMessage = MutableLiveData<String>()
    private val startRefreshing = MutableLiveData<Unit>()
    private val stopRefreshing = MutableLiveData<Unit>()

    fun getCarList(): MutableLiveData<List<CarModel>> = carList
    fun showErrorMessage(): MutableLiveData<String> = errorMessage
    fun startRefreshing(): MutableLiveData<Unit> = startRefreshing
    fun stopRefreshing(): MutableLiveData<Unit> = stopRefreshing

    fun onAttach() {
        startRefreshing.postValue(Unit)
        compositeDisposable += getCarListUseCase.getCarList().subscribe({ carModelList ->
            carList.postValue(carModelList)
            stopRefreshing.postValue(Unit)
        }, {
            stopRefreshing.postValue(Unit)
            errorMessage.postValue(it.message)
        })
    }
}