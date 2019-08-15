package com.example.cars.utils.viewmodel

import dagger.MapKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER)
@MapKey
annotation class ViewModelKey(val value: KClass<out BaseViewModel>)