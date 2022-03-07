package com.seremon.mercadolibre.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.seremon.mercadolibre.BuildConfig
import com.seremon.mercadolibre.R
import com.seremon.mercadolibre.app.App
import com.seremon.mercadolibre.app.model.Product
import com.seremon.mercadolibre.ui.detail.adapter.AttributesAdapter
import com.seremon.mercadolibre.ui.detail.di.DaggerDetailComponent
import com.seremon.mercadolibre.ui.detail.di.DetailComponent
import com.seremon.mercadolibre.ui.detail.di.DetailModule
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.progressBar
import kotlinx.android.synthetic.main.activity_detail.recyclerView
import kotlinx.android.synthetic.main.activity_result.*
import java.text.NumberFormat
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

        recyclerView.adapter = null

        component.inject(this)
        presenter.bindView(this)
        if (intent.hasExtra(PRODUCT)) {
            intent.getParcelableExtra<Product>(PRODUCT)
            presenter.onViewCreated(intent.getParcelableExtra(PRODUCT)!!)
        } else {
            presenter.onEmptyData(R.string.empty_info)
        }
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }

    override fun showLoading() {
        layInfo.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        layInfo.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    override fun publishData(product: Product) {
        val numberFormat = NumberFormat.getCurrencyInstance()
        numberFormat.maximumFractionDigits = 0

        //Load Initial Info
        txtTitle.text = product.title!!.trim()
        txtPrice.text = numberFormat.format(product.price)

        //Load Installment
        if(product.installments!!.quantity != null || product.installments!!.amount != null) {
            txtInstallments.visibility = View.VISIBLE
            val a = product.installments!!.quantity
            val b = numberFormat.format(product.installments!!.amount)
            txtInstallments.text = "en $a coutas de $b"
        }
        else {
            txtInstallments.visibility = View.GONE
        }

        //Load Images
        val slideModel = ArrayList<SlideModel>()

        if(product.pictures.size == 0) slideModel.add(SlideModel(product.thumbnail))

        product.pictures.forEach {
            slideModel.add(SlideModel(it.secureUrl))
        }

        imageSlider.setImageList(slideModel, ScaleTypes.CENTER_INSIDE)
        imageSlider.setBackgroundColor(resources.getColor(R.color.text_shadow_white))

        //Load Attributes
        runOnUiThread(java.lang.Runnable {
            val adapter = AttributesAdapter(product.attributes)
            recyclerView.adapter = adapter
        })

    }

    override fun showMessage(msg: Int) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun initView() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val manager = LinearLayoutManager(this).apply { orientation = LinearLayoutManager.VERTICAL }
        recyclerView.layoutManager = manager
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}