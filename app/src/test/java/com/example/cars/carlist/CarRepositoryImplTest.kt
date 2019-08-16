package com.example.cars.carlist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cars.carlist.CarsMock.Companion.cars
import com.example.cars.carslist.CarRepository
import com.example.cars.carslist.CarRepositoryImpl
import com.example.cars.utils.network.CarsService
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class CarRepositoryImplTest {
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private lateinit var carRepository: CarRepository
    private val carsService: CarsService = mock()

    @Before
    fun setUp() {
        carRepository = CarRepositoryImpl(
            carsService = carsService
        )
    }

    @Test
    fun getCarList_Success() {
        given(carsService.getCarList()).willReturn(
            Observable.just(cars)
        )

        carRepository.getCarList()
                .test()
                .assertResult(cars)
    }

    @Test
    fun getCarList_Error() {
        val error = Exception("test error")
        given(carRepository.getCarList()).willReturn(
            Observable.error(error)
        )

        carRepository.getCarList()
            .test()
            .assertError(error)
    }
}