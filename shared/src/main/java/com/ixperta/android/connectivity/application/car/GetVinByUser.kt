package com.ixperta.android.connectivity.application.car

import com.ixperta.android.connectivity.application.UseCaseAsync
import com.ixperta.android.connectivity.domain.user.repository.UserRepository
import com.ixperta.android.connectivity.domain.vehicle.repository.VehicleRepository
import com.ixperta.android.connectivity.domain.vehicle.values.Vin

class GetVinByUser(
    private val userRepository: UserRepository,
    private val vehicleRepository: VehicleRepository
) : UseCaseAsync<Vin?> {
    override suspend fun execute(): Vin? {
        //miroslav.vinter@skoda-auto.cz
        // tomas.stary@ixperta.com
        //vin se vrací pouze pro tyto dva emaily

        val user = userRepository.getCurrentUser()

        val result = vehicleRepository.getVehiclesForUser(user)

        return result.fold({ null }, { Vin(it.first().vin.value) })


    }
}