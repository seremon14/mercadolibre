package com.seremon.mercadolibre.ui.main

import com.seremon.mercadolibre.app.model.Product

class MainPresenter(private val router: MainContract.Router) :
    MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun bindView(view: MainContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null
    }

    override fun onClickSearch(criteria: String?) {
        if(criteria.isNullOrEmpty() || criteria.isNullOrBlank()){
            view!!.showMessage("Ingresa un criterio de búsqueda")
        }else{
            router.openResult(criteria)
        }
    }

    override fun onBackClicked() {
        router.finish()
    }
}