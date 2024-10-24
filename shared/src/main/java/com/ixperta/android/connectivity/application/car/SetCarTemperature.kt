package com.ixperta.android.connectivity.application.car

import com.ixperta.android.connectivity.application.UseCaseAsync

class SetCarTemperature(value: Int) : UseCaseAsync<Boolean> {
    override suspend fun execute(): Boolean {
        //todo send car temperature

        return true

    }
}