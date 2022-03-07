package com.seremon.mercadolibre.ui.detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.seremon.mercadolibre.R
import com.seremon.mercadolibre.app.model.Attributes
import kotlinx.android.synthetic.main.attribute_item.view.*

class AttributesAdapter(private val attributes: List<Attributes>) :
    RecyclerView.Adapter<AttributesAdapter.AttributesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttributesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.attribute_item, parent, false)
        return AttributesViewHolder(view)
    }

    override fun onBindViewHolder(holder: AttributesViewHolder, position: Int) {
        holder.txtName.text = attributes[position].name!!.trim()
        holder.txtValue.text = attributes[position].valueName!!.trim()
    }

    override fun getItemCount() = attributes.size

    inner class AttributesViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val txtName = itemView.txtName!!
        val txtValue = itemView.txtValue!!
    }
}