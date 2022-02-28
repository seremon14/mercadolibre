package com.seremon.mercadolibre.Model

import androidx.annotation.DrawableRes

class Product (
    val id: Long,
    val name: String,
    @DrawableRes
    val image: Int?,
    val description: String,
    val price: Int
)