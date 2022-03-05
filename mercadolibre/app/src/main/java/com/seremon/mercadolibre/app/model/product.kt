package com.seremon.mercadolibre.app.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    @SerializedName("site") var site: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("desc") var desc: String? = null,
    @SerializedName("link") var link: String? = null,
    @SerializedName("elementPureHtml") var elementPureHtml: String? = null
) : Parcelable