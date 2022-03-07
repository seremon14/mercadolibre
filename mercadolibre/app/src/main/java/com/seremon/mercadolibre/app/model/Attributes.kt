package com.seremon.mercadolibre.app.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Attributes (
    @SerializedName("id"                   ) var id                 : String?           = null,
    @SerializedName("name"                 ) var name               : String?           = null,
    @SerializedName("value_id"             ) var valueId            : String?           = null,
    @SerializedName("attribute_group_id"   ) var attributeGroupId   : String?           = null,
    @SerializedName("value_name"           ) var valueName          : String?           = null,
    @SerializedName("attribute_group_name" ) var attributeGroupName : String?           = null,
    @SerializedName("source"               ) var source             : Long?              = null
) : Parcelable