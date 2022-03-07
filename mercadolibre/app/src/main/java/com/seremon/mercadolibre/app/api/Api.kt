package com.seremon.mercadolibre.app.api

import com.seremon.mercadolibre.app.model.DetailResult
import com.seremon.mercadolibre.app.model.Result
import com.seremon.mercadolibre.app.model.Product
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("https://api.mercadolibre.com/sites/MCO/search")
    fun getProducts(@Query("q", encoded = true) criteria: String?): Single<Result>

    @GET("https://api.mercadolibre.com/items")
    fun getDetailProduct(@Query("ids", encoded = true) id: String?): Single<ArrayList<DetailResult>>
}