package com.seremon.mercadolibre.ui.detail

import com.seremon.mercadolibre.app.model.DetailResult
import com.seremon.mercadolibre.app.model.Product
import io.reactivex.Single

interface DetailContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun publishData(product: Product)
        fun showMessage(msg: Int)
    }

    interface Presenter {
        fun bindView(view: DetailContract.View)

        fun unbindView()

        fun onViewCreated(product: Product)

        fun onBackClicked()

        fun onEmptyData(msg: Int)
    }

    interface Interactor {
        fun getDetailProduct(id: String?, onSuccess: (ArrayList<DetailResult>) -> Unit, onError: (Throwable) -> Unit)
    }

    interface Router {
        fun back()
    }

    interface Repo {
        fun getDetailProduct(id: String?): Single<ArrayList<DetailResult>>
    }
}