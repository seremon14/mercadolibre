package com.seremon.mercadolibre

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            NextScreen()
        }, 1000)
    }

    fun NextScreen(){
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}