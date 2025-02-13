package com.ixperta.android.connectivity

import android.app.Application
import android.util.Log
import com.ixperta.android.connectivity.application.car.GetCarData
import com.ixperta.android.connectivity.application.car.GetProductPlans
import com.ixperta.android.connectivity.application.car.GetVinByUser
import com.ixperta.android.connectivity.application.car.SetBoughtPlan
import com.ixperta.android.connectivity.application.car.SetCarLockedState
import com.ixperta.android.connectivity.configuration.di.appModule
import com.ixperta.android.connectivity.configuration.di.networkingModule
import com.ixperta.android.connectivity.configuration.di.paymentModule
import com.ixperta.android.connectivity.configuration.di.repositoryModule
import com.ixperta.android.connectivity.configuration.di.useCaseModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class CarConnectivityApplication : Application() {
    val TAG = "Application"

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CarConnectivityApplication)
            modules(appModule)
            modules(paymentModule)
            modules(networkingModule)
            modules(repositoryModule)
            modules(useCaseModule)
        }



    }
}

