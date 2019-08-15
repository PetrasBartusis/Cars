package com.example.cars.carslist

import com.example.cars.utils.viewmodel.BaseViewModel
import com.example.cars.utils.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CarListModule private constructor() {
    @Binds
    @IntoMap
    @ViewModelKey(CarListViewModel::class)
    abstract fun bindCarListViewModel(viewModel: CarListViewModel): BaseViewModel
}