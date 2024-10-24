package com.ixperta.android.connectivity.application.car

import com.ixperta.android.connectivity.application.UseCaseAsync
import com.ixperta.android.connectivity.domain.vehicle.entity.VehicleStatusEntity
import com.ixperta.android.connectivity.domain.vehicle.repository.VehicleRepository

class GetCarData(
    private val getVinByUser: GetVinByUser,
    private val vehicleRepository: VehicleRepository
) : UseCaseAsync<VehicleStatusEntity?> {
    override suspend fun execute(): VehicleStatusEntity? {

        val vin = getVinByUser.execute() ?: return null

        val result = vehicleRepository.getVehicleStatus(vin)

        return result.fold({ null }, { it })

    }
}