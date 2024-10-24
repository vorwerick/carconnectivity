package com.ixperta.android.connectivity.application.car

import com.ixperta.android.connectivity.application.UseCaseAsync

class GetBoughtPlan(private val getCarData: GetCarData) : UseCaseAsync<String?> {
    override suspend fun execute(): String? {
        //free, basic, advance, premium
        val carData = getCarData.execute() ?: return null

        return carData.plan
    }
}