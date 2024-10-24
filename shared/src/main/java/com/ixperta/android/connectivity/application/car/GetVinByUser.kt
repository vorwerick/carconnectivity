package com.ixperta.android.connectivity.application.car

import com.ixperta.android.connectivity.application.UseCaseAsyncWith
import com.ixperta.android.connectivity.domain.user.entity.UserEntity
import com.ixperta.android.connectivity.domain.user.repository.UserRepository
import com.ixperta.android.connectivity.domain.vehicle.repository.VehicleRepository
import com.ixperta.android.connectivity.domain.vehicle.values.Vin

class GetVinByUser(
    private val userRepository: UserRepository,
    private val vehicleRepository: VehicleRepository
) : UseCaseAsyncWith<Vin?, UserEntity> {
    override suspend fun execute(value: UserEntity): Vin? {

        val result = vehicleRepository.getVehiclesForUser(value)

        return result.fold({ null }, { Vin(it.first().vin.value) })


    }
}