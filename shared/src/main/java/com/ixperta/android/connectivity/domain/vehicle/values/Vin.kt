package com.ixperta.android.connectivity.domain.vehicle.values


class Vin(val vin: String) {

    init {
        if(vin.isEmpty()){
            throw IllegalArgumentException("Vin is empty")
        }
    }
}