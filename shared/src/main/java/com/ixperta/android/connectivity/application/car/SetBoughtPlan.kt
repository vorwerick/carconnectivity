package com.ixperta.android.connectivity.application.car

import com.ixperta.android.connectivity.application.UseCaseAsync

class SetBoughtPlan(plan: String) : UseCaseAsync<Boolean> {
    override suspend fun execute(): Boolean {
        //todo send bought subscription plan
        //free, basic, advance, premium
        return true

    }
}