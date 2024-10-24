package com.ixperta.android.connectivity.presentation.car

import androidx.lifecycle.ViewModel
import com.ixperta.android.connectivity.application.car.GetCarData
import com.ixperta.android.connectivity.application.payment.CheckIsReadyToPay
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.context.GlobalContext.get
import org.koin.java.KoinJavaComponent

enum class CarType {
    CAR1, CAR2
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

    private val _carRange = MutableStateFlow<Int?>(null)
    val carRange: StateFlow<Int?> = _carRange

    private val _temperature = MutableStateFlow<Int?>(null)
    val temperature: StateFlow<Int?> = _temperature

    private val _chargingLocation = MutableStateFlow<String?>(null)
    val chargingLocation: StateFlow<String?> = _chargingLocation

    private val _carType = MutableStateFlow<CarType?>(null)
    val carType: StateFlow<CarType?> = _carType

    suspend fun fetchData() {
       // val carData: GetCarData = KoinJavaComponent.get(GetCarData::class.java)
        coroutineScope {
            launch {
            //    val data = carData.execute()
                _carName.update { "Octavia" }

                _vehicleStatusLocked.value = true
                _batteryState.value = "Mid"
                _carRange.value = 400
                _temperature.value = 30
                _chargingLocation.value = "Home"
                _carType.value = CarType.CAR1
                _vin.value = "TMBMA239239DMWXCA"
            }
        }
        //todo call repository and fill data

    }

    fun setLockedState(value: Boolean) {
        _vehicleStatusLocked.value = value
    }

    fun increaseTemperature() {
        _temperature.value = _temperature.value?.plus(1)

    }

    fun decreaseTemperature() {
        _temperature.value = _temperature.value?.minus(1)

    }

}