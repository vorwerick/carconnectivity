package com.ixperta.android.connectivity.application.car

import com.ixperta.android.connectivity.application.UseCaseAsyncWith
import com.ixperta.android.connectivity.domain.user.entity.UserEntity
import com.ixperta.android.connectivity.domain.vehicle.repository.VehicleRepository
import java.util.concurrent.locks.Lock

enum class LockedStatus {
    locked, unlocked
}

class SetCarLockedInput(val status: LockedStatus, val user: UserEntity)

class SetCarLockedState(
    private val getVinByUser: GetVinByUser,
    private val getCarData: GetCarData,
    private val vehicleRepository: VehicleRepository
) : UseCaseAsyncWith<Boolean, SetCarLockedInput> {

    override suspend fun execute(value: SetCarLockedInput): Boolean {
        val vin = getVinByUser.execute(value.user) ?: return false

        val currentStatus = getCarData.execute(value.user) ?: return false

        val newStatus = currentStatus.copy(lockStats = value.status.toString())

        val result = vehicleRepository.setVehicleStatus(vin, newStatus)

        return result

    }
}