package com.seremon.mercadolibre.ui.result.adapter

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Build
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.seremon.mercadolibre.R
import com.seremon.mercadolibre.app.model.Product
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.product_item.view.*
import java.text.NumberFormat

@SuppressLint("StaticFieldLeak")
@Suppress("DEPRECATION")
class ProductsAdapter (private val products: List<Product>, private val listener: ProductListener) :
    RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    private val numberFormat = NumberFormat.getCurrencyInstance()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        numberFormat.maximumFractionDigits = 0;


        DownloadImageFromInternet(holder.imgProduct).execute(products[position].thumbnail)
        holder.title.text = products[position].title!!.trim()
        holder.price.text = numberFormat.format(products[position].price)


        if(products[position].installments != null && (products[position].installments!!.quantity != null || products[position].installments!!.amount != null)) {
            holder.installments.visibility = View.VISIBLE
            val a = products[position].installments!!.quantity
            val b = numberFormat.format(products[position].installments!!.amount)
            holder.installments.text = "en $a coutas de $b"
        }
        else {
            holder.installments.visibility = View.GONE
        }

        holder.description.visibility =
            if (products[position].acceptsMercadopago!!){
                View.VISIBLE
            } else{
                View.INVISIBLE
            }

        holder.itemView.setOnClickListener { listener.onItemClick(products[position]) }
    }

    override fun getItemCount() = products.size

    inner class ProductViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val imgProduct = itemView.imgProduct!!
        val title = itemView.txtTitle!!
        val description = itemView.txtDescription!!
        val price = itemView.txtPrice!!
        val installments = itemView.txtInstallments!!
    }

    interface ProductListener {
        fun onItemClick(product: Product)
    }

    private inner class DownloadImageFromInternet(var imageView: ImageView) : AsyncTask<String, Void, Bitmap?>() {

        override fun doInBackground(vararg urls: String): Bitmap? {
            val imageURL = urls[0]
            var image: Bitmap? = null
            try {
                val stream = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(stream)
            }
            catch (e: Exception) {
                Log.e("Error Message", e.message.toString())
                e.printStackTrace()
            }
            return image
        }

        override fun onPostExecute(result: Bitmap?) {
            imageView.setImageBitmap(result)
        }
    }

}
