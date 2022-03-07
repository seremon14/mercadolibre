package com.seremon.mercadolibre.ui.main

import android.location.Criteria
import com.seremon.mercadolibre.app.model.Product
import io.reactivex.Single

interface MainContract {
    interface View {
        fun showMessage(msg: String)
    }

    interface Presenter {
        fun bindView(view: MainContract.View)
        fun unbindView()
        fun onClickSearch(criteria: String?)
        fun onBackClicked()
    }

    interface Router {
        fun finish()
        fun openResult(criteria: String?)
    }
}