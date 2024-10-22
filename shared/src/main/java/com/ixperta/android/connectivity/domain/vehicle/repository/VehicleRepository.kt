package com.ixperta.android.connectivity.domain.vehicle.repository

import arrow.core.Either
import com.ixperta.android.connectivity.domain.vehicle.entity.VehicleEntity
import com.ixperta.android.connectivity.domain.vehicle.entity.VehicleStatusEntity
import com.ixperta.android.connectivity.domain.vehicle.values.Vin

interface VehicleRepository {
    fun getVehiclesForUser( token: String): Either<Unit, List<VehicleEntity>>

    fun getVehicleStatus(vin: Vin): Either<Unit, VehicleStatusEntity>
}