package com.seremon.mercadolibre.app.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pictures (

    @SerializedName("id"         ) var id        : String? = null,
    @SerializedName("url"        ) var url       : String? = null,
    @SerializedName("secure_url" ) var secureUrl : String? = null,
    @SerializedName("size"       ) var size      : String? = null,
    @SerializedName("max_size"   ) var maxSize   : String? = null,
    @SerializedName("quality"    ) var quality   : String? = null

) : Parcelable