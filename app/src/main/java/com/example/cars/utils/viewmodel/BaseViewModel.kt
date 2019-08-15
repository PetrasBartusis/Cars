package com.example.cars.utils.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel: ViewModel() {
    val compositeDisposable = CompositeDisposable()

    fun clearDisposable() {
        compositeDisposable.clear()
    }
}