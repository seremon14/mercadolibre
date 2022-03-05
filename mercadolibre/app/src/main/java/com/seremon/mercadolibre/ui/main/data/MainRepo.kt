package com.seremon.mercadolibre.ui.main.data

import com.seremon.mercadolibre.app.model.Product
import com.seremon.mercadolibre.ui.main.MainContract
import com.seremon.mercadolibre.ui.main.api.MainApi
import io.reactivex.Single

class MainRepo(private val api: MainApi) : MainContract.Repo {

    override fun getProducts(): Single<List<Product>> = api.getData()
}