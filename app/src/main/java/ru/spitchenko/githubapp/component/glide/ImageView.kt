package ru.spitchenko.githubapp.component.glide

import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions

fun ImageView.setImageGlide(
    imageUrl: String?,
    imagePlaceholder: Int?
) {

    val requestOptions = RequestOptions.centerCropTransform()
        .placeholder(imagePlaceholder ?: 0)

    GlideApp.with(this)
        .load(imageUrl)
        .apply(requestOptions)
        .into(this)
}