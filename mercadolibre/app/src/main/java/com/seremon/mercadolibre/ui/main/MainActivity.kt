package com.seremon.mercadolibre.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.seremon.mercadolibre.R
import com.seremon.mercadolibre.app.App
import com.seremon.mercadolibre.ui.main.di.DaggerMainComponent
import com.seremon.mercadolibre.ui.main.di.MainComponent
import com.seremon.mercadolibre.ui.main.di.MainModule
import com.seremon.mercadolibre.ui.result.ResultActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    @Inject
    lateinit var presenter: MainPresenter

    val component: MainComponent by lazy {
        DaggerMainComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(MainModule())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        component.inject(this)
        presenter.bindView(this)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }

    override fun showLoading() {
        //recyclerView.visibility = View.GONE
        //progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        //recyclerView.visibility = View.VISIBLE
        //progressBar.visibility = View.GONE
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun initView() {
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
        startActivity(Intent(this, ResultActivity::class.java))
    }
}