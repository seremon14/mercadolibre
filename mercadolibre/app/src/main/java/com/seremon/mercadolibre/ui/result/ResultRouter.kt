package com.seremon.mercadolibre.ui.result

import com.seremon.mercadolibre.app.model.Product
import com.seremon.mercadolibre.ui.detail.DetailActivity

class ResultRouter(private val activity: ResultActivity) : ResultContract.Router {
    override fun back() {
        activity.onBackPressed()
    }

    override fun openDetailProduct(data: Product) {
        DetailActivity.launch(activity, data)
    }
}