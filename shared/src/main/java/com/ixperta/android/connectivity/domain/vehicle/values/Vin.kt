package com.ixperta.android.connectivity.domain.vehicle.values


class Vin(val value: String) {

    init {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Vin is empty")
        }
    }

    override fun toString(): String {
        return "Vin=$value"
    }
}