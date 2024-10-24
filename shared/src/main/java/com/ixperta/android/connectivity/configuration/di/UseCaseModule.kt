package com.ixperta.android.connectivity.configuration.di

import com.ixperta.android.connectivity.application.car.GetBoughtPlan
import com.ixperta.android.connectivity.application.car.GetCarData
import com.ixperta.android.connectivity.application.car.GetProductPlans
import com.ixperta.android.connectivity.application.car.GetVinByUser
import com.ixperta.android.connectivity.application.car.SetBoughtPlan
import com.ixperta.android.connectivity.application.car.SetCarLockedState
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        GetVinByUser(get(), get())
    }

    factory {
        GetProductPlans(get())
    }

    factory {
        GetCarData(get(), get())
    }
    factory {
        GetBoughtPlan(get())
    }

    factory {
        SetBoughtPlan(get(), get(), get())
    }

    factory {
        SetCarLockedState(get(), get(), get())
    }
}