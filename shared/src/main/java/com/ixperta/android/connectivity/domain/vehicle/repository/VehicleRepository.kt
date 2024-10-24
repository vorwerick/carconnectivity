package com.ixperta.android.connectivity.domain.vehicle.repository

import arrow.core.Either
import com.ixperta.android.connectivity.domain.user.entity.UserEntity
import com.ixperta.android.connectivity.domain.vehicle.entity.VehicleEntity
import com.ixperta.android.connectivity.domain.vehicle.entity.VehicleStatusEntity
import com.ixperta.android.connectivity.domain.vehicle.values.Vin

interface VehicleRepository {

    suspend fun getVehiclesForUser(user: UserEntity): Either<Unit, List<VehicleEntity>>

    suspend fun getVehicleStatus(vin: Vin): Either<Unit, VehicleStatusEntity>

    suspend fun setVehicleStatus(vin: Vin, newPlan: VehicleStatusEntity): Boolean
}