package com.seremon.mercadolibre.app.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    @SerializedName("id"                   ) var id                  : String?               = null,
    @SerializedName("site_id"              ) var siteId              : String?               = null,
    @SerializedName("title"                ) var title               : String?               = null,
    @SerializedName("price"                ) var price               : Long?                  = null,
    @SerializedName("sale_price"           ) var salePrice           : String?               = null,
    @SerializedName("currency_id"          ) var currencyId          : String?               = null,
    @SerializedName("available_quantity"   ) var availableQuantity   : Long?                  = null,
    @SerializedName("sold_quantity"        ) var soldQuantity        : Long?                  = null,
    @SerializedName("stop_time"            ) var stopTime            : String?               = null,
    @SerializedName("condition"            ) var condition           : String?               = null,
    @SerializedName("permalink"            ) var permalink           : String?               = null,
    @SerializedName("thumbnail"            ) var thumbnail           : String?               = null,
    @SerializedName("thumbnail_id"         ) var thumbnailId         : String?               = null,
    @SerializedName("accepts_mercadopago"  ) var acceptsMercadopago  : Boolean?              = null,
    @SerializedName("installments"         ) var installments        : Installments?         = Installments(),
    @SerializedName("address"              ) var address             : Address?              = Address(),
    @SerializedName("attributes"           ) var attributes          : ArrayList<Attributes> = arrayListOf(),
    @SerializedName("pictures"             ) var pictures            : ArrayList<Pictures>   = arrayListOf(),
    @SerializedName("original_price"       ) var originalPrice       : String?               = null,
    @SerializedName("category_id"          ) var categoryId          : String?               = null,
    @SerializedName("official_store_id"    ) var officialStoreId     : String?               = null,
    @SerializedName("domain_id"            ) var domainId            : String?               = null,
    @SerializedName("catalog_product_id"   ) var catalogProductId    : String?               = null,
    @SerializedName("tags"                 ) var tags                : ArrayList<String>     = arrayListOf(),
    @SerializedName("order_backend"        ) var orderBackend        : Long?                  = null,
    @SerializedName("use_thumbnail_id"     ) var useThumbnailId      : Boolean?              = null,
    @SerializedName("offer_score"          ) var offerScore          : String?               = null,
    @SerializedName("offer_share"          ) var offerShare          : String?               = null,
    @SerializedName("match_score"          ) var matchScore          : String?               = null,
    @SerializedName("winner_item_id"       ) var winnerItemId        : String?               = null,
    @SerializedName("melicoin"             ) var melicoin            : String?               = null
) : Parcelable