package com.seremon.mercadolibre.ui.detail

import com.seremon.mercadolibre.app.model.Product

interface DetailContract {
    interface View {
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

    interface Router {
        fun finish()
    }
}