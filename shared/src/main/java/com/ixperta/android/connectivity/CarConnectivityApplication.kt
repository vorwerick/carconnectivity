package com.ixperta.android.connectivity

import android.app.Application
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.tasks.Task
import com.google.android.gms.wallet.PaymentData
import com.google.android.gms.wallet.contract.TaskResultContracts.GetPaymentDataResult
import com.ixperta.android.connectivity.application.payment.CheckIsReadyToPay
import com.ixperta.android.connectivity.application.payment.LoadPaymentData
import com.ixperta.android.connectivity.configuration.di.appModule
import com.ixperta.android.connectivity.presentation.payment.awaitTask
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class CarConnectivityApplication : Application() {
val TAG= "Application"

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CarConnectivityApplication)
            modules(appModule)

        }



    }



}