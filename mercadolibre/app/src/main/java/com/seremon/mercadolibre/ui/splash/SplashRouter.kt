package com.seremon.mercadolibre.ui.splash

import com.seremon.mercadolibre.ui.main.MainActivity

class SplashRouter(private val activity: SplashActivity) : SplashContract.Router {

    override fun openMain() {
        MainActivity.launch(activity)
        activity.finish()
    }
}