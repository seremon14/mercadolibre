package com.seremon.mercadolibre.ui.detail.data

import com.seremon.mercadolibre.app.api.Api
import com.seremon.mercadolibre.app.model.DetailResult
import com.seremon.mercadolibre.app.model.Result
import com.seremon.mercadolibre.ui.detail.DetailContract
import io.reactivex.Single

class DetailRepo(private val api: Api) : DetailContract.Repo {

    override fun getDetailProduct(id: String?): Single<ArrayList<DetailResult>> = api.getDetailProduct(id)
}