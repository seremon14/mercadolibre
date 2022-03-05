package com.seremon.mercadolibre.ui.main

import com.seremon.mercadolibre.app.model.Product
import com.seremon.mercadolibre.ui.main.data.MainRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainInteractor(private val repo: MainRepo) : MainContract.Interactor {

    private val compositeDisposable = CompositeDisposable()

    override fun getProducts(onSuccess: (List<Product>) -> Unit, onError: (Throwable) -> Unit) {
        val disposable = repo.getProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError(onError)
            .doOnSuccess(onSuccess)
            .subscribe()

        compositeDisposable.add(disposable)
    }

    fun dispose() = compositeDisposable.dispose()
}