package com.ixperta.android.connectivity.domain.vehicle.entity

import com.ixperta.android.connectivity.domain.vehicle.values.Vin

data class VehicleStatusEntity(
    val vin: Vin,
    val plan: String,
    val lockStats: String,
    val range: String,
    val rangeUnit: String,
    val lat: String,
    val lon: String,
    val maxZoom: Int,
    val heater: String,
    val startTime: String,
    val rangeApprox: String,
)