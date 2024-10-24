package com.ixperta.android.connectivity.application.car

import com.ixperta.android.connectivity.application.UseCaseAsyncWith
import com.ixperta.android.connectivity.domain.vehicle.repository.VehicleRepository

enum class BoughtPlan {
    free, basic, advance, premium
}

class SetBoughtPlan(
    private val getVinByUser: GetVinByUser,
    private val getCarData: GetCarData,
    private val vehicleRepository: VehicleRepository
) : UseCaseAsyncWith<Boolean, BoughtPlan> {
    override suspend fun execute(value: BoughtPlan): Boolean {

        val vin = getVinByUser.execute() ?: return false

        val currentStatus = getCarData.execute() ?: return false

        val newStatus = currentStatus.copy(plan = value.toString())

        val result = vehicleRepository.setVehicleStatus(vin, newStatus)

        return result

    }
}