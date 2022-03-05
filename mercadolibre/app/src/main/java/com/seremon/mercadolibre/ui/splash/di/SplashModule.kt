package com.seremon.mercadolibre.ui.splash.di

import com.seremon.mercadolibre.app.di.ActivityScope
import com.seremon.mercadolibre.ui.splash.SplashActivity
import com.seremon.mercadolibre.ui.splash.SplashContract
import com.seremon.mercadolibre.ui.splash.SplashPresenter
import com.seremon.mercadolibre.ui.splash.SplashRouter
import dagger.Module
import dagger.Provides

@Module
class SplashModule {

    @Provides
    @ActivityScope
    fun router(activity: SplashActivity): SplashContract.Router = SplashRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router: SplashContract.Router) = SplashPresenter(router)
}