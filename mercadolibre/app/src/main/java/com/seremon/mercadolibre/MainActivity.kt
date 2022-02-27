package com.seremon.mercadolibre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val customTitleSupported =  requestWindowFeature(Window.FEATURE_CUSTOM_TITLE)
        setContentView(R.layout.activity_main)

        if (customTitleSupported) {
            supportActionBar!!.hide()
            window.setBackgroundDrawableResource(R.color.colorBackgroud)
        }
    }
}