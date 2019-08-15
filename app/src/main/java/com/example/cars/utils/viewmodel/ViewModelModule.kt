package com.example.cars.utils.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.example.cars.carslist.CarsListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CarsListViewModel::class)
    protected abstract fun provideCarsViewModel(carsViewModel: CarsListViewModel): BaseViewModel
}