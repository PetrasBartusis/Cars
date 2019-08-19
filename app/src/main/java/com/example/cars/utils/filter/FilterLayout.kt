package com.example.cars.utils.filter

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.CheckBox
import android.widget.LinearLayout
import com.example.cars.R
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.filter_layout.view.*

class FilterLayout(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    val value
        get() = FilterOptions(
                plateNumberFilter = plateNumberFilterText.text?.toString() ?: "",
                remainingBatteryFilter = remainingBatteryFilterText.text?.toString()?.toIntOrNull()
                        ?: 0,
                distanceFilter = distanceFilterCheckbox.isChecked
        )

    private val plateNumberFilterText: TextInputEditText
    private val remainingBatteryFilterText: TextInputEditText
    private val distanceFilterCheckbox: CheckBox

    init {
        val view = View.inflate(context, R.layout.filter_layout, null).apply {
            layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                orientation = VERTICAL
            }
        }
        plateNumberFilterText = view.plateFilterText
        remainingBatteryFilterText = view.remainingBatteryText
        distanceFilterCheckbox = view.matchDistanceFromUserCheckbox
        addView(view)
    }
}