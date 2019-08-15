package com.example.cars.utils.activity

import androidx.fragment.app.FragmentActivity
import com.example.cars.MainActivity

fun FragmentActivity.showMessage(message: String) {
    (this as MainActivity).showMessage(message)
}

fun FragmentActivity.showMessage(messageResId: Int) {
    (this as MainActivity).showMessage(getString(messageResId))
}