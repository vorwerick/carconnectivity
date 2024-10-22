package com.ixperta.android.connectivity.infrastructure.mocks

import arrow.core.Either
import com.ixperta.android.connectivity.domain.vehicle.entity.VehicleEntity
import com.ixperta.android.connectivity.domain.vehicle.entity.VehicleStatusEntity
import com.ixperta.android.connectivity.domain.vehicle.repository.VehicleRepository
import com.ixperta.android.connectivity.domain.vehicle.values.Vin

class MockedVehicleRepository: VehicleRepository {
    override fun getVehiclesForUser(token: String): Either<Unit, List<VehicleEntity>> {
        return Either.Right(listOf(VehicleEntity(Vin("TMBDS1123123"))))
    }

    override fun getVehicleStatus(vin: Vin): Either<Unit, VehicleStatusEntity> {
        return Either.Right(VehicleStatusEntity(Vin("TMBDS1123123"), "MockedPlan"))
    }
}