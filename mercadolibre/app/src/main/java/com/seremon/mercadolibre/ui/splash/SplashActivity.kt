package com.seremon.mercadolibre.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.seremon.mercadolibre.R
import com.seremon.mercadolibre.app.App
import com.seremon.mercadolibre.ui.splash.di.DaggerSplashComponent
import com.seremon.mercadolibre.ui.splash.di.SplashComponent
import com.seremon.mercadolibre.ui.splash.di.SplashModule
import javax.inject.Inject


class SplashActivity : AppCompatActivity(), SplashContract.View {

    @Inject
    lateinit var presenter: SplashPresenter

    val component: SplashComponent by lazy {
        DaggerSplashComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(SplashModule())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        component.inject(this)
        presenter.bindView(this)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }
}




/*class SplashActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            NextScreen()
        }, 1000)
    }

    fun NextScreen(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}*/