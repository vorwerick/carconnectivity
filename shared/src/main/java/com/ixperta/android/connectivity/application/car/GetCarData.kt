package com.ixperta.android.connectivity.application.car

import com.ixperta.android.connectivity.application.UseCaseAsyncWith
import com.ixperta.android.connectivity.domain.user.entity.UserEntity
import com.ixperta.android.connectivity.domain.vehicle.entity.VehicleStatusEntity
import com.ixperta.android.connectivity.domain.vehicle.repository.VehicleRepository

class GetCarData(
    private val getVinByUser: GetVinByUser,
    private val vehicleRepository: VehicleRepository
) : UseCaseAsyncWith<VehicleStatusEntity?, UserEntity> {
    override suspend fun execute(value: UserEntity): VehicleStatusEntity? {

        val vin = getVinByUser.execute(value) ?: return null

        val result = vehicleRepository.getVehicleStatus(vin)

        return result.fold({ null }, { it })

    }
}