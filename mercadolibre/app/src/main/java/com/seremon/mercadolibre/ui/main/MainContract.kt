package com.seremon.mercadolibre.ui.main

import com.seremon.mercadolibre.app.model.Product
import io.reactivex.Single

interface MainContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        //fun publishData(data: List<Product>)
        fun showMessage(msg: String)
    }

    interface Presenter {

        fun bindView(view: MainContract.View)

        fun unbindView()

        fun onViewCreated()

        fun onItemClicked(product: Product)

        fun onBackClicked()
    }

    interface Interactor {
        fun getProducts(onSuccess: (List<Product>) -> Unit, onError: (Throwable) -> Unit)
    }

    interface Router {
        fun finish()
        fun openDetailProduct(product: Product)
    }

    interface Repo {
        fun getProducts(): Single<List<Product>>
    }
}