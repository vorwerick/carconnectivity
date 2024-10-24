package com.ixperta.android.connectivity.domain.catalog.enity

import com.ixperta.android.connectivity.domain.common.Entity

data class PlanEntity(
    val name: String,
    val displayName: String,
    val subtitle: String,
    val priceMonthly: Int,
    val priceAnnually: Int,
    val priceUnit: String
) : Entity()
