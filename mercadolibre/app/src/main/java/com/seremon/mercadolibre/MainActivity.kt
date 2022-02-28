package com.seremon.mercadolibre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val customTitleSupported =  requestWindowFeature(Window.FEATURE_CUSTOM_TITLE)
        setContentView(R.layout.activity_main)

        //if (customTitleSupported) {
            supportActionBar!!.hide()
        //}

        val txtWelcome = findViewById<TextView>(R.id.txtWelcome);
        txtWelcome.text = resources.getString(R.string.Bienvenido);
        val txtSubtitle = findViewById<TextView>(R.id.txtSubtitle);
        txtSubtitle.text = resources.getString(R.string.TituloBusqueda);

    }
}