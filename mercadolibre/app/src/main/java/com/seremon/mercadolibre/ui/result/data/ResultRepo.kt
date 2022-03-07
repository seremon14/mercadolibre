package com.seremon.mercadolibre.ui.result.data

import com.seremon.mercadolibre.app.api.Api
import com.seremon.mercadolibre.app.model.Product
import com.seremon.mercadolibre.app.model.Result
import com.seremon.mercadolibre.ui.result.ResultContract
import io.reactivex.Single

class ResultRepo(private val api: Api) : ResultContract.Repo {

    override fun getProducts(criteria: String?): Single<Result> = api.getProducts(criteria)
}