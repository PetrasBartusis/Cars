package com.example.cars.carslist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.entities.CarModel
import com.example.cars.utils.image.ImageLoader
import kotlinx.android.synthetic.main.item_car_model.view.*

class CarModelViewHolder(
    itemView: View,
    private val imageLoader: ImageLoader
): RecyclerView.ViewHolder(itemView) {
    fun bind(carModel: CarModel) {
        itemView.carModelTitleTextView.text = carModel.title
        imageLoader.loadImage(itemView.carModelImageView, carModel.photoUrl)
    }
}