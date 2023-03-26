package com.link.awesome.presenter.viewmodels

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapters {
    @JvmStatic
    @BindingAdapter(value = ["imageUrl"])
    fun loadImage(view: ImageView, url: String?) {
        Log.d("TEST", "")
    }
}