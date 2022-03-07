package com.seremon.mercadolibre.app.model

import com.google.gson.annotations.SerializedName

class Result (

    @SerializedName("site_id"                   ) var siteId                 : String?                     = null,
    @SerializedName("country_default_time_zone" ) var countryDefaultTimeZone : String?                     = null,
    @SerializedName("query"                     ) var query                  : String?                     = null,
    @SerializedName("results"                   ) var results                : ArrayList<Product>          = arrayListOf()

)