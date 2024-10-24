package com.ixperta.android.connectivity.application.car

import com.ixperta.android.connectivity.application.UseCaseAsync

class GetBoughtPlan(plan: String) : UseCaseAsync<String?> {
    override suspend fun execute(): String? {
        //todo send bought subscription plan
        //free, basic, advance, premium
        return null

    }
}