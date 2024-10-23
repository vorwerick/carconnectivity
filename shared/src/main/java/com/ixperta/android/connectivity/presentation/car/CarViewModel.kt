package com.ixperta.android.connectivity.presentation.car

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CarViewModel() : ViewModel() {

    private val _carName = MutableStateFlow<String>("")
    val carName: StateFlow<String> = _carName

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

    fun fetchData() {

        //todo call repository and fill data
        _carName.value = "Octavia"
        _vehicleStatusLocked.value = true
        _batteryState.value = "Mid"
        _carRange.value = 400
        _temperature.value = 30
        _chargingLocation.value = "Home"
    }

}