package com.seremon.mercadolibre.ui.detail

import com.seremon.mercadolibre.app.model.DetailResult
import com.seremon.mercadolibre.ui.detail.data.DetailRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class DetailInteractor (private val repo: DetailRepo) : DetailContract.Interactor {

    private val compositeDisposable = CompositeDisposable()

    override fun getDetailProduct(
        id: String?,
        onSuccess: (ArrayList<DetailResult>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val disposable = repo.getDetailProduct(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError(onError)
            .doOnSuccess(onSuccess)
            .subscribe()

        compositeDisposable.add(disposable)
    }

    fun dispose() = compositeDisposable.dispose()
}