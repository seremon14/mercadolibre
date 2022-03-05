package com.seremon.mercadolibre.ui.main

import com.seremon.mercadolibre.app.model.Product

class MainPresenter(private val router: MainContract.Router, private val interactor: MainInteractor) :
    MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun bindView(view: MainContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null
        interactor.dispose()
    }

    override fun onViewCreated() {
        view?.showLoading()
        interactor.getProducts({
            view?.hideLoading()
            //view?.publishData(it)
        }, this::onError)
    }

    override fun onItemClicked(product: Product) {
        router.openDetailProduct(product)
    }

    override fun onBackClicked() {
        router.finish()
    }

    private fun onError(error: Throwable) {
        view?.hideLoading()
        error.message?.let { view?.showMessage(it) }
    }
}