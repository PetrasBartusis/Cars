package com.example.cars.utils.dialog.filter

data class FilterOptions(
        var plateNumberFilter: String = "",
        var remainingBatteryFilter: Int = 0,
        var distanceFilter: Boolean = false
)