package com.example.cars.carslist

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.R
import com.example.cars.entities.CarModel
import com.example.cars.utils.image.ImageLoader
import kotlinx.android.synthetic.main.item_car_model.view.*

class CarModelViewHolder(
    itemView: View,
    private val imageLoader: ImageLoader
) : RecyclerView.ViewHolder(itemView) {
    @SuppressLint("SetTextI18n")
    fun bind(carModel: CarModel) {
        itemView.carModelTitleTextView.text = carModel.title
        itemView.plateNumberTextView.text = carModel.plateNumber
        itemView.addressTextView.text = carModel.location.address
        itemView.remainingBatteryTextView.text = "${carModel.remainingBattery} ${itemView.context.getString(
            R.string.remaining_battery_text
        )}"
        imageLoader.loadImage(itemView.carModelImageView, carModel.photoUrl)
    }
}