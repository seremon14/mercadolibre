package com.seremon.mercadolibre.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.seremon.mercadolibre.BuildConfig
import com.seremon.mercadolibre.app.model.Product
import com.seremon.mercadolibre.R
import com.seremon.mercadolibre.app.App
import com.seremon.mercadolibre.ui.detail.di.DaggerDetailComponent
import com.seremon.mercadolibre.ui.detail.di.DetailComponent
import com.seremon.mercadolibre.ui.detail.di.DetailModule
import javax.inject.Inject

class DetailActivity: AppCompatActivity(), DetailContract.View {

    companion object {
        private const val PRODUCT = "${BuildConfig.APPLICATION_ID}_PRODUCT"

        fun launch(context: Context, data: Product) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(PRODUCT, data)
            context.startActivity(intent)
        }
    }

    @Inject
    lateinit var presenter: DetailPresenter

    val component: DetailComponent by lazy {
        DaggerDetailComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(DetailModule())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initView()
        component.inject(this)
        presenter.bindView(this)
        if (intent.hasExtra(PRODUCT)) {
            intent.getParcelableExtra<Product>(PRODUCT)
            presenter.onViewCreated(intent.getParcelableExtra(PRODUCT)!!)
        } else {
           // presenter.onEmptyData(R.string.empty_data)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }

    override fun publishData(product: Product) {

    }

    override fun showMessage(msg: Int) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun initView() {
        supportActionBar!!.hide()


        var imageSlider = findViewById<ImageSlider>(R.id.image_slider)

        val slideModel = ArrayList<SlideModel>()

        slideModel.add(SlideModel("https://bit.ly/2YoJ77H", "The animal population decreased by 58 percent in 42 years."))
        slideModel.add(SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct."))
        slideModel.add(SlideModel("https://bit.ly/3fLJf72", "And people do that."))

        imageSlider.setImageList(slideModel, ScaleTypes.FIT)
    }

}







/*: AppCompatActivity() {
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
}*/