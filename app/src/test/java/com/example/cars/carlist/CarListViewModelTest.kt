package com.example.cars.carlist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cars.carlist.CarsMock.Companion.cars
import com.example.cars.carslist.CarListViewModel
import com.example.cars.carslist.GetCarListUseCase
import com.jraska.livedata.test
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import java.lang.Exception

class CarListViewModelTest {
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private lateinit var carListViewModel: CarListViewModel
    private val getCarListUseCase: GetCarListUseCase = mock()

    @Before
    fun setUp() {
        carListViewModel = CarListViewModel(
            getCarListUseCase = getCarListUseCase
        )
    }

    @Test
    fun onAttach_loadInitialCarList_Success() {
        given(getCarListUseCase.getCarList()).willReturn(
            Observable.just(cars)
        )

        carListViewModel.onAttach()

        carListViewModel.startRefreshing().test()
        carListViewModel.getCarList().test()
        carListViewModel.stopRefreshing().test()
    }

    @Test
    fun onAttach_loadInitialCarList_Error() {
        val errorMessage = "error test"
        given(getCarListUseCase.getCarList()).willReturn(
            Observable.error(Exception(errorMessage))
        )

        carListViewModel.onAttach()

        carListViewModel.startRefreshing().test()
        carListViewModel.stopRefreshing().test()
        carListViewModel.showErrorMessage().test()
            .assertValue(errorMessage)
    }
}