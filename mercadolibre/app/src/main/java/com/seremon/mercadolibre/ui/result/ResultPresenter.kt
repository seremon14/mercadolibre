package com.seremon.mercadolibre.ui.result

import com.seremon.mercadolibre.app.model.Product

class ResultPresenter (private val router: ResultContract.Router, private val interactor: ResultInteractor) :
    ResultContract.Presenter {

    private var view: ResultContract.View? = null

    override fun bindView(view: ResultContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null
        interactor.dispose()
    }

    override fun onViewCreated(criteria: String?) {
        view?.showLoading()
        interactor.getProducts(
            criteria,
            {
                view?.hideLoading()
                view?.publishData(it.results)
            }, 
            this::onError)
    }

    override fun onItemClicked(product: Product) {
        router.openDetailProduct(product)
    }

    override fun onBackClicked() {
        router.back()
    }

    private fun onError(error: Throwable) {
        view?.hideLoading()
        error.message?.let { view?.showMessage(it) }
        router.back()
    }
}