package com.ixperta.android.connectivity

import android.app.Application
import com.ixperta.android.connectivity.configuration.di.appModule
import org.koin.core.context.startKoin


class CarConnectivityApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin { modules(appModule) }
    }
}