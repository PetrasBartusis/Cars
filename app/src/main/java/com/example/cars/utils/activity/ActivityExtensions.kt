package com.example.cars.utils.activity

import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentActivity
import com.example.cars.MainActivity
import kotlinx.android.synthetic.main.activity_main.*

fun FragmentActivity.showMessage(message: String) {
    (this as MainActivity).showMessage(message)
}

fun FragmentActivity.showMessage(messageResId: Int) {
    (this as MainActivity).showMessage(getString(messageResId))
}

fun FragmentActivity.openDrawer() {
    drawer.openDrawer(GravityCompat.START)
}