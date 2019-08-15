package com.example.cars.carslist

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.cars.R
import com.example.cars.utils.activity.showMessage
import com.example.cars.utils.fragment.BaseFragment
import com.example.cars.utils.image.ImageLoader
import kotlinx.android.synthetic.main.fragment_cars_list.*
import javax.inject.Inject

class CarListFragment: BaseFragment(), SwipeRefreshLayout.OnRefreshListener {
    override fun onRefresh() {
        viewModel.onAttach()
    }

    @Inject
    lateinit var imageLoader: ImageLoader

    private val viewModel: CarListViewModel by lazy {
        ViewModelProviders.of(
                this,
                viewModelFactory
        ).get(CarListViewModel::class.java)
    }

    private val carModelAdapter by lazy {
        CarModelAdapter(
            imageLoader = imageLoader
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getCarList().observe(this, Observer {
            carModelAdapter.setCarModelList(it)
        })
        viewModel.showErrorMessage().observe(this, Observer {
            activity?.showMessage(it)
        })
        viewModel.startRefreshing().observe(this, Observer {
            swipeRefreshLayout.isRefreshing = true
        })
        viewModel.stopRefreshing().observe(this, Observer {
            swipeRefreshLayout.isRefreshing = false
        })
        recyclerView.apply {
            adapter = carModelAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        swipeRefreshLayout.setOnRefreshListener(this)
        viewModel.onAttach()
    }

    override val layoutRes: Int = R.layout.fragment_cars_list
}
