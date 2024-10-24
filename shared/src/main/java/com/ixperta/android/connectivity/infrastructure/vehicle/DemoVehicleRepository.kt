package com.ixperta.android.connectivity.infrastructure.vehicle

import arrow.core.Either
import coil.network.HttpException
import com.ixperta.android.connectivity.domain.user.entity.UserEntity
import com.ixperta.android.connectivity.domain.vehicle.entity.VehicleEntity
import com.ixperta.android.connectivity.domain.vehicle.entity.VehicleStatusEntity
import com.ixperta.android.connectivity.domain.vehicle.repository.VehicleRepository
import com.ixperta.android.connectivity.domain.vehicle.values.Vin
import com.ixperta.android.connectivity.infrastructure.api.DemoApiService
import com.ixperta.android.connectivity.infrastructure.api.model.VehicleSupport

class DemoVehicleRepository(private val api: DemoApiService) : VehicleRepository {
    override suspend fun getVehiclesForUser(user: UserEntity): Either<Unit, List<VehicleEntity>> {

        val email = user.email

        try {

            val response = api.getUserSupport(email)

            val vehicles = response.map { VehicleEntity(Vin(it)) }
            return Either.Right(vehicles)

        } catch (e: HttpException) {
            return Either.Left(Unit)
        }
    }

    override suspend fun getVehicleStatus(vin: Vin): Either<Unit, VehicleStatusEntity> {

        try {

            val response = api.getVehicleSupport(vin.value)

            val vehicleStatus = VehicleStatusEntity(
                vin,
                response?.plan,
                response?.lockStatus,
                response?.range,
                response?.rangeUnit,
                response?.lat,
                response?.lon,
                response?.maxZoom,
                response?.heater,
                response?.startTime,
                response?.rangeApprox,
            )

            return Either.Right(vehicleStatus)
        } catch (e: HttpException) {
            return Either.Left(Unit)
        }
    }

    override suspend fun setVehicleStatus(vin: Vin, newPlan: VehicleStatusEntity): Boolean {
        try {

            val statusModel = VehicleSupport(
                newPlan.plan,
                newPlan.lockStats,
                newPlan.range,
                newPlan.rangeUnit,
                newPlan.lat,
                newPlan.lon,
                newPlan.maxZoom,
                newPlan.heater,
                newPlan.startTime,
                newPlan.rangeApprox
            )

            api.putVehicleSupport(vin.value, statusModel)
            return true

        } catch (e: HttpException) {
            return false
        }

    }


}