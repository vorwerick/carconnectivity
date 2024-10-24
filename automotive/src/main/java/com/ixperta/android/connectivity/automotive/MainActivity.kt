package com.ixperta.android.connectivity.automotive

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ixperta.android.connectivity.AppConfig
import com.ixperta.android.connectivity.ConnectivityApp

class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val appConfig = AppConfig(isAutomotiveOS = true)

        setContent {
            ConnectivityApp(appConfig)
        }
    }
}