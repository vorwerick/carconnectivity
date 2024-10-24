package com.ixperta.android.connectivity.application.car

import com.ixperta.android.connectivity.application.UseCaseAsyncWith
import com.ixperta.android.connectivity.domain.user.entity.UserEntity
import com.ixperta.android.connectivity.domain.vehicle.repository.VehicleRepository
import com.ixperta.android.connectivity.presentation.car.SubscriptionPlans


class BoughtPlanInput(val plan: SubscriptionPlans, val user: UserEntity){

}

class SetBoughtPlan(
    private val getVinByUser: GetVinByUser,
    private val getCarData: GetCarData,
    private val vehicleRepository: VehicleRepository
) : UseCaseAsyncWith<Boolean, BoughtPlanInput> {
    override suspend fun execute(value: BoughtPlanInput): Boolean {

        val vin = getVinByUser.execute(value.user) ?: return false

        val currentStatus = getCarData.execute(value.user) ?: return false

        val newStatus = currentStatus.copy(plan = value.plan.toString())

        val result = vehicleRepository.setVehicleStatus(vin, newStatus)

        return result

    }
}