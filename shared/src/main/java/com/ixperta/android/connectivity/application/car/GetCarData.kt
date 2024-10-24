package com.ixperta.android.connectivity.application.car

import com.ixperta.android.connectivity.application.UseCaseAsync
import java.util.concurrent.locks.Lock

enum class LockedStatus{
    locked, unlocked
}
data class CarData(
    val plan: String,
    val isLocked: LockedStatus,
    val rangeApprox: String, //battery range
    val lat: String,
    val lng: String,
    val maxZoom: Int,
    val temperature: Int,
)

class GetCarData() : UseCaseAsync<CarData?> {
    override suspend fun execute(): CarData? {
        //todo get car data from repository
        return null

    }
}