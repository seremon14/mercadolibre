package com.seremon.mercadolibre

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.seremon.mercadolibre.Model.Product
import java.text.NumberFormat

class ProductsAdapter (private val products: List<Product>, private val onClick: (Product) -> Unit) : RecyclerView.Adapter<ProductViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount() = products.size
}

/* ViewHolder for Product, takes in the inflated view and the onClick behavior. */
class ProductViewHolder(itemView: View, val onClick: (Product) -> Unit) :
    RecyclerView.ViewHolder(itemView) {
    private val productTextView: TextView = itemView.findViewById(R.id.txtTitle)
    private val productImageView: ImageView = itemView.findViewById(R.id.imgProduct)
    private val productDescription: TextView = itemView.findViewById(R.id.txtDescription)
    private val productPrice: TextView = itemView.findViewById(R.id.txtPrice)
    private var currentProduct: Product? = null
    private val numberFormat = NumberFormat.getCurrencyInstance()

    init {

        numberFormat.maximumFractionDigits = 0;

        itemView.setOnClickListener {
            currentProduct?.let {
                onClick(it)
            }
        }
    }

    /* Bind product name and image. */
    fun bind(product: Product) {
        currentProduct = product

        productTextView.text = product.name
        productDescription.text = product.description
        productPrice.text = numberFormat.format(product.price)

        if (product.image != null) {
            productImageView.setImageResource(product.image)
        } else {
            productImageView.setImageResource(R.mipmap.ic_user)
        }
    }
}
