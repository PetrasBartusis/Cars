package com.example.cars.utils.viewmodel

import androidx.lifecycle.ViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModelProvider
import javax.inject.Provider

class ViewModelFactory @Inject
constructor(private val viewModels: MutableMap<Class<out BaseViewModel>, Provider<BaseViewModel>>) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        modelClass as Class<BaseViewModel>
        val creator = viewModels[modelClass]
            ?: viewModels.asIterable().firstOrNull { modelClass.isAssignableFrom(it.key) }?.value
            ?: throw IllegalArgumentException("unknown model class $modelClass")
        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}