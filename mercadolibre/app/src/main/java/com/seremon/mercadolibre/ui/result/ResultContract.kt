package com.seremon.mercadolibre.ui.result

import com.seremon.mercadolibre.app.model.Product
import com.seremon.mercadolibre.app.model.Result
import io.reactivex.Single

interface ResultContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun publishData(data: ArrayList<Product>)
        fun showMessage(msg: String)
    }

    interface Presenter {

        fun bindView(view: ResultContract.View)

        fun unbindView()

        fun onViewCreated(criteria: String?)

        fun onItemClicked(product: Product)

        fun onBackClicked()
    }

    interface Interactor {
        fun getProducts(criteria: String?, onSuccess: (Result) -> Unit, onError: (Throwable) -> Unit)
    }

    interface Router {
        fun back()
        fun openDetailProduct(product: Product)
    }

    interface Repo {
        fun getProducts(criteria: String?): Single<Result>
    }
}