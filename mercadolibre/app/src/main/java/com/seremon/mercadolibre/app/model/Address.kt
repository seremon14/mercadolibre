package com.seremon.mercadolibre.app.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
class Address (

    @SerializedName("state_id"   ) var stateId   : String? = null,
    @SerializedName("state_name" ) var stateName : String? = null,
    @SerializedName("city_id"    ) var cityId    : String? = null,
    @SerializedName("city_name"  ) var cityName  : String? = null

) : Parcelable
