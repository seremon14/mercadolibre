package com.seremon.mercadolibre.ui.result.di

import com.seremon.mercadolibre.app.api.Api
import com.seremon.mercadolibre.app.di.ActivityScope
import com.seremon.mercadolibre.ui.result.*
import com.seremon.mercadolibre.ui.result.data.ResultRepo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ResultModule{

    @Provides
    @ActivityScope
    fun api(retrofit: Retrofit) = retrofit.create(Api::class.java)

    @Provides
    @ActivityScope
    fun repository(api: Api) = ResultRepo(api)


    @Provides
    @ActivityScope
    fun router(activity: ResultActivity): ResultContract.Router = ResultRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router: ResultContract.Router, interactor: ResultInteractor) = ResultPresenter(router, interactor)

    @Provides
    @ActivityScope
    fun interactor(repository: ResultRepo) = ResultInteractor(repository)
}