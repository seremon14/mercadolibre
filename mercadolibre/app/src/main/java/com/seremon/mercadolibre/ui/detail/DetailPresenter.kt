package com.seremon.mercadolibre.ui.detail

import com.seremon.mercadolibre.app.model.Product

class DetailPresenter(private val router: DetailContract.Router) : DetailContract.Presenter {

    private var view: DetailContract.View? = null

    override fun bindView(view: DetailContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null
    }

    override fun onViewCreated(product: Product) {
        view?.publishData(product)
    }

    override fun onEmptyData(msg: Int) {
        view?.showMessage(msg)
        router.finish()
    }

    override fun onBackClicked() {
        router.finish()
    }
}