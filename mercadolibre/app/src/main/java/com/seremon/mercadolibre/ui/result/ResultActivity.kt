package com.seremon.mercadolibre.ui.result

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import androidx.recyclerview.widget.LinearLayoutManager
import com.seremon.mercadolibre.BuildConfig
import com.seremon.mercadolibre.R
import com.seremon.mercadolibre.app.App
import com.seremon.mercadolibre.app.model.Product
import com.seremon.mercadolibre.ui.result.adapter.ProductsAdapter
import com.seremon.mercadolibre.ui.result.di.DaggerResultComponent
import com.seremon.mercadolibre.ui.result.di.ResultComponent
import com.seremon.mercadolibre.ui.result.di.ResultModule
import kotlinx.android.synthetic.main.activity_result.*
import javax.inject.Inject


class ResultActivity : AppCompatActivity(), ResultContract.View {


    companion object {
        private const val CRITERIA = "${BuildConfig.APPLICATION_ID}_CRITERIA"

        fun launch(context: Context, criteria: String?) {
            val intent = Intent(context, ResultActivity::class.java)
            intent.putExtra(CRITERIA, criteria)
            context.startActivity(intent)
        }
    }

    @Inject
    lateinit var presenter: ResultPresenter

    val component: ResultComponent by lazy {
        DaggerResultComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(ResultModule())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        recyclerView.adapter = null

        component.inject(this)
        presenter.bindView(this)
        presenter.onViewCreated(intent.getStringExtra(CRITERIA))

        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }

    override fun showLoading() {
        recyclerView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        recyclerView.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    override fun publishData(data: ArrayList<Product>) {
        runOnUiThread(java.lang.Runnable {
            val adapter = ProductsAdapter(data, object : ProductsAdapter.ProductListener {
                override fun onItemClick(product: Product) {
                    presenter.onItemClicked(product)
                }
            })
            recyclerView.adapter = adapter
        })

    }

    override fun showMessage(msg: String) {
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
                presenter.onBackClicked()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}