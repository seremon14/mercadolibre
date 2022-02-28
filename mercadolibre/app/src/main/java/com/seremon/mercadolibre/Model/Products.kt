package com.seremon.mercadolibre.Model

import android.content.res.Resources
import com.seremon.mercadolibre.R

fun productList() : List<Product> {
    return listOf(
        Product(
            id = 1,
            name = "Vaca",
            image = R.drawable.ic_search,
            price = 540000,
            description = "La vaca feliz"
        ),
        Product(
            id = 2,
            name = "iPhone",
            image = R.drawable.ic_search,
            price = 508880000,
            description = "El mejor iPhone del mundo"
        ),
        Product(
            id = 3,
            name = "iPhone 2",
            image = R.drawable.ic_search,
            price = 500099990,
            description = "El mejor iPhone del mundo"
        ),
        Product(
            id = 4,
            name = "iPhone 3",
            image = R.drawable.ic_search,
            price = 500434000,
            description = "El mejor iPhone del mundo"
        ),
        Product(
            id = 5,
            name = "iPhone 4",
            image = R.drawable.ic_search,
            price = 500000,
            description = "El mejor iPhone del mundo"
        ),
        Product(
            id = 6,
            name = "iPhone 5",
            image = R.drawable.ic_search,
            price = 500000,
            description = "El mejor iPhone del mundo"
        ),
        Product(
            id = 7,
            name = "iPhone 6",
            image = R.drawable.ic_search,
            price = 500000,
            description = "El mejor iPhone del mundo"
        ),
        Product(
            id = 8,
            name = "iPhone 7",
            image = R.drawable.ic_search,
            price = 500000,
            description = "El mejor iPhone del mundo"
        ),
        Product(
            id = 9,
            name = "iPhone 8",
            image = R.drawable.ic_search,
            price = 500000,
            description = "El mejor iPhone del mundo"
        ),
        Product(
            id = 10,
            name = "iPhone 9",
            image = R.drawable.ic_search,
            price = 500000,
            description = "El mejor iPhone del mundo"
        ),
        Product(
            id = 11,
            name = "iPhone 10",
            image = R.drawable.ic_search,
            price = 500000,
            description = "El mejor iPhone del mundo"
        )
    )
}