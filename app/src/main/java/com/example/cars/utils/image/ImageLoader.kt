package com.example.cars.utils.image

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.cars.R
import javax.inject.Inject

class ImageLoader @Inject constructor() {
    fun loadImage(
        imageView: ImageView,
        url: String
    ) {
        Glide.with(imageView)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.ic_image)
            .into(imageView)
    }
}