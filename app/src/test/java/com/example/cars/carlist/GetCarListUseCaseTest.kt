package com.example.cars.carlist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cars.carlist.CarsMock.Companion.cars
import com.example.cars.carslist.CarRepository
import com.example.cars.carslist.GetCarListUseCase
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class GetCarListUseCaseTest {
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private lateinit var getCarListUseCase: GetCarListUseCase
    private val carRepository: CarRepository = mock()

    @Before
    fun setUp() {
        getCarListUseCase = GetCarListUseCase(carRepository)
    }

    @Test
    fun getCarList_Success() {
        given(carRepository.getCarList()).willReturn(
            Observable.just(cars)
        )

        getCarListUseCase.getCarList()
            .test()
            .assertResult(cars)
            .assertComplete()
    }

    @Test
    fun getCarList_Error() {
        val error = Exception("test error")
        given(carRepository.getCarList()).willReturn(
            Observable.error(error)
        )

        getCarListUseCase.getCarList()
            .test()
            .assertError(error)
    }
}