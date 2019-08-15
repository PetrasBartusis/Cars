package com.example.cars.carslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.R
import com.example.cars.entities.CarModel
import com.example.cars.utils.image.ImageLoader

class CarModelAdapter(
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<CarModelViewHolder>()  {
    private var carModelList = mutableListOf<CarModel>()

    fun setCarModelList(articles: List<CarModel>) {
        carModelList.clear()
        carModelList.addAll(articles)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CarModelViewHolder =
        CarModelViewHolder(
            itemView = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_car_model, viewGroup, false),
            imageLoader = imageLoader
        )

    override fun getItemCount(): Int = carModelList.size

    override fun onBindViewHolder(holder: CarModelViewHolder, position: Int) {
        holder.bind(carModelList[position])
    }
}
