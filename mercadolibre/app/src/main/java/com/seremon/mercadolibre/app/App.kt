package com.seremon.mercadolibre.app

import android.app.Application
import com.seremon.mercadolibre.app.di.AppComponent
import com.seremon.mercadolibre.app.di.AppModule
import com.seremon.mercadolibre.app.di.DaggerAppComponent

class App : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .context(this)
            .plus(AppModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        component.inject(this)
    }
}