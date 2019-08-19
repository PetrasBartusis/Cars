package com.example.cars.utils.location

import android.location.Location
import com.example.cars.entities.CarModel

class CarLocationComparator(
        private var origin: Location
) : Comparator<CarModel?> {
    override fun compare(left: CarModel?, right: CarModel?): Int {
        return origin.distanceTo(left?.location?.toLocation())
                .compareTo(origin.distanceTo(right?.location?.toLocation()))
    }
}