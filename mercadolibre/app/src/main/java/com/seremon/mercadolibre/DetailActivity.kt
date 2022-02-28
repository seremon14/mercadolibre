package com.seremon.mercadolibre

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel

class DetailActivity: AppCompatActivity() {
    lateinit var imageSlider:ImageSlider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar!!.hide()


        imageSlider = findViewById<ImageSlider>(R.id.image_slider)

        val slideModel = ArrayList<SlideModel>()

        slideModel.add(SlideModel("https://bit.ly/2YoJ77H", "The animal population decreased by 58 percent in 42 years."))
        slideModel.add(SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct."))
        slideModel.add(SlideModel("https://bit.ly/3fLJf72", "And people do that."))

        imageSlider.setImageList(slideModel, ScaleTypes.FIT)

        //val txtWelcome = findViewById<TextView>(R.id.txtWelcome);
        //txtWelcome.text = resources.getString(R.string.Bienvenido);
        //val txtSubtitle = findViewById<TextView>(R.id.txtSubtitle);
        //txtSubtitle.text = resources.getString(R.string.TituloBusqueda);

    }
}