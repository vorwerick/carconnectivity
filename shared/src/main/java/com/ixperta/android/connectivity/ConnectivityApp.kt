package com.ixperta.android.connectivity

import androidx.activity.result.ActivityResultLauncher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.tasks.Task
import com.google.android.gms.wallet.PaymentData
import com.ixperta.android.connectivity.configuration.app.AppConfig
import com.ixperta.android.connectivity.presentation.auth.AuthViewModel


@Composable
fun ConnectivityApp(appConfig: AppConfig) {
    val authViewModel = viewModel { AuthViewModel() }

    val coroutineScope = rememberCoroutineScope()


    Main(authViewModel, appConfig)


}

