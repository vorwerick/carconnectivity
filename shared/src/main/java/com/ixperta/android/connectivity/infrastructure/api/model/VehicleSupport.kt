package com.ixperta.android.connectivity.infrastructure.api.model

import com.google.gson.annotations.SerializedName

data class VehicleSupport(
    val plan: String,
    @SerializedName("lock_status")
    val lockStatus: String,
    val range: String,
    @SerializedName("range_unit")
    val rangeUnit: String,
    val lat: String,
    val lon: String,
    @SerializedName("max_zoom")
    val maxZoom: Int,
    val heater: String,
    @SerializedName("start_time")
    val startTime: String,
    @SerializedName("range_approx")
    val rangeApprox: String

)