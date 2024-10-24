package com.ixperta.android.connectivity.application.car

import com.ixperta.android.connectivity.application.UseCaseAsyncWith
import com.ixperta.android.connectivity.domain.vehicle.repository.VehicleRepository

enum class LockedStatus {
    locked, unlocked
}

class SetCarLockedState(
    private val getVinByUser: GetVinByUser,
    private val getCarData: GetCarData,
    private val vehicleRepository: VehicleRepository
) : UseCaseAsyncWith<Boolean, LockedStatus> {

    override suspend fun execute(value: LockedStatus): Boolean {
        val vin = getVinByUser.execute() ?: return false

        val currentStatus = getCarData.execute() ?: return false

        val newStatus = currentStatus.copy(lockStats = value.toString())

        val result = vehicleRepository.setVehicleStatus(vin, newStatus)

        return result

    }
}