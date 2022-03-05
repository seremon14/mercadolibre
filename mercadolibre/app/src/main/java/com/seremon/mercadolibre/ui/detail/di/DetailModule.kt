package com.seremon.mercadolibre.ui.detail.di

import com.seremon.mercadolibre.app.di.ActivityScope
import com.seremon.mercadolibre.ui.detail.DetailActivity
import com.seremon.mercadolibre.ui.detail.DetailContract
import com.seremon.mercadolibre.ui.detail.DetailPresenter
import com.seremon.mercadolibre.ui.detail.DetailRouter
import dagger.Module
import dagger.Provides

@Module
class DetailModule {

    @Provides
    @ActivityScope
    fun router(activity: DetailActivity): DetailContract.Router = DetailRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router: DetailContract.Router) = DetailPresenter(router)
}