package com.seremon.mercadolibre.ui.result

import com.seremon.mercadolibre.app.model.Product
import com.seremon.mercadolibre.app.model.Result
import com.seremon.mercadolibre.ui.result.data.ResultRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ResultInteractor (private val repo: ResultRepo) : ResultContract.Interactor {

    private val compositeDisposable = CompositeDisposable()

    override fun getProducts(
        criteria: String?,
        onSuccess: (Result) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val disposable = repo.getProducts(criteria)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError(onError)
            .doOnSuccess(onSuccess)
            .subscribe()

        compositeDisposable.add(disposable)
    }

    fun dispose() = compositeDisposable.dispose()
}