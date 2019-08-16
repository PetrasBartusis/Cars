package com.example.cars.carmap

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cars.carlist.CarsMock.Companion.cars
import com.example.cars.carslist.CarListViewModel
import com.example.cars.carslist.GetCarListUseCase
import com.example.cars.map.MapViewModel
import com.jraska.livedata.test
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import java.lang.Exception

class CarMapViewModelTest {
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private lateinit var mapViewModel: MapViewModel
    private val getCarListUseCase: GetCarListUseCase = mock()

    @Before
    fun setUp() {
        mapViewModel = MapViewModel(
                getCarListUseCase = getCarListUseCase
        )
    }

    @Test
    fun onAttach_loadInitialCarList_Success() {
        given(getCarListUseCase.getCarList()).willReturn(
                Observable.just(cars)
        )

        mapViewModel.onAttach()

        mapViewModel.getCars().test()
        mapViewModel.zoomListener().test()
    }

    @Test
    fun onAttach_loadInitialCarList_Error() {
        val errorMessage = "error test"
        given(getCarListUseCase.getCarList()).willReturn(
                Observable.error(Exception(errorMessage))
        )

        mapViewModel.onAttach()

        mapViewModel.showMessage().test()
                .assertValue(errorMessage)
    }
}