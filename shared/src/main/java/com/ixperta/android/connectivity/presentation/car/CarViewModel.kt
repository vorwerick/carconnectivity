package com.ixperta.android.connectivity.presentation.car

import androidx.lifecycle.ViewModel
import com.ixperta.android.connectivity.application.car.BoughtPlanInput
import com.ixperta.android.connectivity.application.car.GetCarData
import com.ixperta.android.connectivity.application.car.LockedStatus
import com.ixperta.android.connectivity.application.car.SetBoughtPlan
import com.ixperta.android.connectivity.application.car.SetCarLockedInput
import com.ixperta.android.connectivity.application.car.SetCarLockedState
import com.ixperta.android.connectivity.domain.user.entity.UserEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.java.KoinJavaComponent.get

enum class CarType {
    CAR1, CAR2
}

enum class SubscriptionPlans {
    free, basic, advanced, premium
}

class CarViewModel() : ViewModel() {

    private val _carName = MutableStateFlow<String>("")
    val carName: StateFlow<String> = _carName

    private val _vin = MutableStateFlow<String>("")
    val vin: StateFlow<String> = _vin

    private val _vehicleStatusLocked = MutableStateFlow<Boolean?>(null)
    val vehicleStatusLocked: StateFlow<Boolean?> = _vehicleStatusLocked

    private val _batteryState = MutableStateFlow<String?>(null)
    val batteryState: StateFlow<String?> = _batteryState

    private val _carRange = MutableStateFlow<String?>(null)
    val carRange: StateFlow<String?> = _carRange

    private val _temperature = MutableStateFlow<Int?>(null)
    val temperature: StateFlow<Int?> = _temperature

    private val _heater = MutableStateFlow<String?>(null)
    val heater: StateFlow<String?> = _heater

    private val _lat = MutableStateFlow<String?>(null)
    val lat: StateFlow<String?> = _lat
    private val _lng = MutableStateFlow<String?>(null)
    val lng: StateFlow<String?> = _lng

    private val _carType = MutableStateFlow<CarType?>(null)
    val carType: StateFlow<CarType?> = _carType

    private val _plan = MutableStateFlow<SubscriptionPlans>(SubscriptionPlans.free)
    val plan: StateFlow<SubscriptionPlans> = _plan

    private val _zoom = MutableStateFlow<Int?>(null)
    val zoom: StateFlow<Int?> = _zoom


    suspend fun fetchData(userEntity: UserEntity) {
        val carData: GetCarData = get(GetCarData::class.java)
        val result = carData.execute(userEntity)
        result?.also {
            _carName.value = "Octavia"
            _vehicleStatusLocked.value =
                LockedStatus.locked == LockedStatus.valueOf(it.lockStats ?: "unlocked")
            _batteryState.value = it.rangeApprox
            _carRange.value = it.range
            _temperature.value = 22
            _heater.value = it.heater
            _lat.value = it.lat
            _lng.value = it.lon

            _zoom.value = it.maxZoom
            _carType.value = CarType.CAR1
            it.vin?.also { v ->
                _vin.value = v.value
            }


            if (it.plan != null) {
                _plan.value = SubscriptionPlans.valueOf(it.plan)
            } else {
                _plan.value = SubscriptionPlans.free
            }

        }

    }

    suspend fun setLockedState(value: Boolean, user: String) {
        var state = LockedStatus.unlocked
        if (value) {
            state = LockedStatus.locked
        }
        val setLocked: SetCarLockedState = get(SetCarLockedState::class.java)
        setLocked.execute(SetCarLockedInput(state, UserEntity(user)))
        _vehicleStatusLocked.value = value
    }

    fun increaseTemperature() {
        _temperature.value = _temperature.value?.plus(1)

    }

    fun decreaseTemperature() {
        _temperature.value = _temperature.value?.minus(1)

    }

    suspend fun boughtPlan(subscriptionPlan: SubscriptionPlans, user: String) {
        val setBoughtPlan: SetBoughtPlan = get(SetBoughtPlan::class.java)
        setBoughtPlan.execute(BoughtPlanInput(subscriptionPlan, UserEntity(user)))

        _plan.value = subscriptionPlan
    }

}