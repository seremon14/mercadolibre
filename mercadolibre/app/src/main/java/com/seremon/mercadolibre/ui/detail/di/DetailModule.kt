package com.seremon.mercadolibre.ui.detail.di

import com.seremon.mercadolibre.app.api.Api
import com.seremon.mercadolibre.app.di.ActivityScope
import com.seremon.mercadolibre.ui.detail.*
import com.seremon.mercadolibre.ui.detail.data.DetailRepo
import com.seremon.mercadolibre.ui.result.ResultInteractor
import com.seremon.mercadolibre.ui.result.data.ResultRepo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class DetailModule {

    @Provides
    @ActivityScope
    fun api(retrofit: Retrofit) = retrofit.create(Api::class.java)

    @Provides
    @ActivityScope
    fun repository(api: Api) = DetailRepo(api)

    @Provides
    @ActivityScope
    fun router(activity: DetailActivity): DetailContract.Router = DetailRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router: DetailContract.Router, interactor: DetailInteractor) = DetailPresenter(router, interactor)

    @Provides
    @ActivityScope
    fun interactor(repository: DetailRepo) = DetailInteractor(repository)
}