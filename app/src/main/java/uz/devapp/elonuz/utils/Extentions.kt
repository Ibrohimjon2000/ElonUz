package uz.devapp.elonuz.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import uz.devapp.elonuz.R

fun ImageView.loadImage(url: String) {
    Glide.with(this.context).load(Constants.BASE_URL + url)
        .placeholder(R.drawable.placeholder)
        .into(this)
}