package com.ixperta.android.connectivity

import android.app.Application
import android.util.Log
import com.ixperta.android.connectivity.application.car.BoughtPlan
import com.ixperta.android.connectivity.application.car.GetBoughtPlan
import com.ixperta.android.connectivity.application.car.GetCarData
import com.ixperta.android.connectivity.application.car.GetProductPlans
import com.ixperta.android.connectivity.application.car.GetVinByUser
import com.ixperta.android.connectivity.application.car.LockedStatus
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

        //Use Cases
        val vinUseCase: GetVinByUser = get()
        val plansFromCatalog: GetProductPlans = get()
        val getCarData: GetCarData = get()
        val getBoughtPlan: GetBoughtPlan = get()
        val setBoughtPlan: SetBoughtPlan = get()
        val setLockedState: SetCarLockedState = get()

        CoroutineScope(Dispatchers.Default).launch {
            // getVinByUser
            val vin = vinUseCase.execute()
            Log.d(TAG, "VIN: $vin")

            // getProductsPlan
            val plans = plansFromCatalog.execute()
            Log.d(TAG, "Plans: $plans")

            // getCarData
            val carData = getCarData.execute()
            Log.d(TAG, "Car data: $carData")

            // getBoughtPlan
            val boughtPlan = getBoughtPlan.execute()
            Log.d(TAG, "Bought plan: $boughtPlan")

            // setBoughtPlan
            val newPlanIsSet = setBoughtPlan.execute(BoughtPlan.basic)
            Log.d(TAG, "Is new plan set: $newPlanIsSet")

            // setBoughtPlan
            val newLockIsSet = setLockedState.execute(LockedStatus.unlocked)
            Log.d(TAG, "Is new lock state set: $newLockIsSet")

        }


    }
}

