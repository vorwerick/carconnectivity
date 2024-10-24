package com.ixperta.android.connectivity.application.car

import com.ixperta.android.connectivity.application.UseCaseAsync

data class Plan(
    val name: String,
    val displayName: String,
    val subtitle: String,
    val priceMonthly: Int,
    val priceAnnually: Int,
    val priceUnit: String
)

class GetProductPlans() : UseCaseAsync<Plan?> {
    override suspend fun execute(): Plan? {
        //todo get bought subscription plan
        return null

    }
}