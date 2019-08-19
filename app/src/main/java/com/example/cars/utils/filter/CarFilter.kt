package com.example.cars.utils.filter

import android.location.Location
import com.example.cars.entities.CarModel
import com.example.cars.utils.location.CarLocationComparator
import java.util.Collections.sort
import javax.inject.Inject

class CarFilter @Inject constructor() {
    fun filterList(carList: List<CarModel>, filterOptions: FilterOptions): List<CarModel> {
        return carList.filter { it.plateNumber.contains(filterOptions.plateNumberFilter, ignoreCase = true) }
                .filter { it.remainingBattery >= filterOptions.remainingBatteryFilter }
    }

    fun sortByDistance(carList: List<CarModel>, location: Location): List<CarModel> {
        sort(carList, CarLocationComparator(location))
        return carList
    }
}
