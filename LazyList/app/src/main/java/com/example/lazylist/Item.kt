package com.example.lazylist

import androidx.annotation.DrawableRes

data class Item(
    val title: String,
    @DrawableRes val imageResId: Int,
)
