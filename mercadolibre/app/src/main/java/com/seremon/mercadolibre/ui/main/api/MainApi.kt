package com.seremon.mercadolibre.ui.main.api

import com.seremon.mercadolibre.app.model.Product
import io.reactivex.Single
import retrofit2.http.GET

interface MainApi {

    @GET("api/random")
    fun getData(): Single<List<Product>>
}