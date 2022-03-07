package com.seremon.mercadolibre.ui.main.di

import com.seremon.mercadolibre.app.api.Api
import com.seremon.mercadolibre.app.di.ActivityScope
import com.seremon.mercadolibre.ui.main.*
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MainModule {

    @Provides
    @ActivityScope
    fun router(activity: MainActivity): MainContract.Router = MainRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router: MainContract.Router) = MainPresenter(router)
}