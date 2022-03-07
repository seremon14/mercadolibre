package com.seremon.mercadolibre.ui.detail

import com.seremon.mercadolibre.R
import com.seremon.mercadolibre.app.model.Product

class DetailPresenter(private val router: DetailContract.Router, private val interactor: DetailInteractor) : DetailContract.Presenter {

    private var view: DetailContract.View? = null

    override fun bindView(view: DetailContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null
    }

    override fun onViewCreated(product: Product) {
        view?.showLoading()
        interactor.getDetailProduct(
            product.id,
            {
                view?.hideLoading()
                view?.publishData(it[0].body!!)
            },
            this::onError)

        //view?.publishData(product)
    }

    override fun onEmptyData(msg: Int) {
        view?.showMessage(msg)
        router.back()
    }

    override fun onBackClicked() {
        router.back()
    }

    private fun onError(error: Throwable) {
        view?.hideLoading()
        error.message?.let { view?.showMessage(R.string.empty_info) }
        router.back()
    }
}