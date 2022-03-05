package com.seremon.mercadolibre.ui.result

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.seremon.mercadolibre.Model.Product2
import com.seremon.mercadolibre.Model.productList
import com.seremon.mercadolibre.ProductsAdapter
import com.seremon.mercadolibre.R
import com.seremon.mercadolibre.ui.detail.DetailActivity

class ResultActivity : AppCompatActivity() {


    private val PRODUCT_ID = "PRODUCT_ID";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        /* Instantiates headerAdapter and productsAdapter. Both adapters are added to concatAdapter.
        which displays the contents sequentially */
        val productsAdapter = ProductsAdapter(productList(), { product -> adapterOnClick(product) })

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = productsAdapter
    }

    /* Opens ProductDetailActivity when RecyclerView item is clicked. */
    private fun adapterOnClick(product: Product2) {
        val intent = Intent(this, DetailActivity()::class.java)
        intent.putExtra(PRODUCT_ID, product.id)
        startActivity(intent)
    }

}