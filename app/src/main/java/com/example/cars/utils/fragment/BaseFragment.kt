package com.example.cars.utils.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cars.utils.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment: DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(layoutRes, container, false)

    abstract val layoutRes: Int

    abstract override fun onViewCreated(view: View, savedInstanceState: Bundle?)

    //abstract val viewModel: BaseViewModel
}