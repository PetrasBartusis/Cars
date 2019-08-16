package com.example.cars.map

import com.example.cars.utils.viewmodel.BaseViewModel
import com.example.cars.utils.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MapModule private constructor() {
    @Binds
    @IntoMap
    @ViewModelKey(MapViewModel::class)
    abstract fun bindMapViewModel(viewModel: MapViewModel): BaseViewModel
}