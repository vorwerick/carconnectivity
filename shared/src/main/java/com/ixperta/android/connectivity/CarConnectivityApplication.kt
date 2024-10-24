package com.ixperta.android.connectivity

import android.app.Application
import com.ixperta.android.connectivity.configuration.di.appModule
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