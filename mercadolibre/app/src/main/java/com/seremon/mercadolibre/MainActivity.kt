package com.seremon.mercadolibre

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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

        val btnSearch = findViewById<ImageButton>(R.id.btnSearch);
        btnSearch.setOnClickListener{
            NextScreen()
        }

    }

    private fun NextScreen(){
        startActivity(Intent(this,ResultActivity::class.java))
    }
}