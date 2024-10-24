package com.ixperta.android.connectivity.application.car

import com.ixperta.android.connectivity.application.UseCaseAsync

class GetVinByUser(email: String) : UseCaseAsync<String?> {
    override suspend fun execute(): String? {
        //miroslav.vinter@skoda-auto.cz
        // tomas.stary@ixperta.com
        //vin se vrací pouze pro tyto dva emaily
        return null

    }
}