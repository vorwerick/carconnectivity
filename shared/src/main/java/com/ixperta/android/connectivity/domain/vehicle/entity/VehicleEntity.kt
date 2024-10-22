package com.ixperta.android.connectivity.domain.vehicle.entity

import com.ixperta.android.connectivity.domain.common.Entity
import com.ixperta.android.connectivity.domain.vehicle.values.Vin

data class VehicleEntity(val vin: Vin): Entity()