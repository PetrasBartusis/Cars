package com.example.cars

import com.example.cars.carslist.CarListFragment
import com.example.cars.carslist.CarListModule
import com.example.cars.map.MapFragment
import com.example.cars.map.MapModule
import com.example.cars.utils.location.DefaultLocationManager
import com.example.cars.utils.location.LocationManager
import com.tbruyelle.rxpermissions2.RxPermissions
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import pl.charmas.android.reactivelocation2.ReactiveLocationProvider

@Module
abstract class MainModule private constructor() {
    @ContributesAndroidInjector(modules = [CarListModule::class])
    abstract fun contributesCarListFragment(): CarListFragment

    @ContributesAndroidInjector(modules = [MapModule::class])
    abstract fun contributesMapFragment(): MapFragment

    @Binds
    abstract fun bindLocationManager(locationManager: DefaultLocationManager): LocationManager

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideReactiveLocationProvider(mainActivity: MainActivity) =
                ReactiveLocationProvider(mainActivity)

        @JvmStatic
        @Provides
        fun provideRxPermissions(mainActivity: MainActivity) =
                RxPermissions(mainActivity)
    }
}