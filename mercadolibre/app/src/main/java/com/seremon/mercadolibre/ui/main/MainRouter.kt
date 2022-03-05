package com.seremon.mercadolibre.ui.main

import com.seremon.mercadolibre.app.model.Product
import com.seremon.mercadolibre.ui.result.ResultActivity

class MainRouter(private val activity: MainActivity) : MainContract.Router {
    override fun finish() {
        activity.finish()
    }

    override fun openDetailProduct(data: Product) {
        //ResultActivity.launch(activity, data)
    }
}