package com.ixperta.android.connectivity.application.car

import com.ixperta.android.connectivity.application.UseCaseAsync

class SetCarLockedState(locked: Boolean) : UseCaseAsync<Boolean> {
    override suspend fun execute(): Boolean {
        //todo send locked state

        return true

    }
}