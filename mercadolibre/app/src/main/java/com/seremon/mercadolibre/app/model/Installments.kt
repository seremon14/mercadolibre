package com.seremon.mercadolibre.app.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Installments (

    @SerializedName("quantity"    ) var quantity   : Long?    = null,
    @SerializedName("amount"      ) var amount     : Double? = null,
    @SerializedName("rate"        ) var rate       : Long?    = null,
    @SerializedName("currency_id" ) var currencyId : String? = null

) : Parcelable
