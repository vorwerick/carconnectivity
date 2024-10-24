package com.ixperta.android.connectivity.infrastructure.api.model

import com.google.gson.annotations.SerializedName

data class CatalogItem(
    val name: String,
    @SerializedName("display_name")
    val displayName: String,
    val subtitle: String,
    @SerializedName("price_monthly")
    val priceMonthly: Int,
    @SerializedName("price_annually")
    val priceAnnually: Int,
    @SerializedName("price_unit")
    val priceUnit: String
)