package com.example.cars.utils.filter

data class FilterOptions(
        var plateNumberFilter: String = "",
        var remainingBatteryFilter: Int = 0,
        var distanceFilter: Boolean = false
)