package com.ixperta.android.connectivity

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ixperta.android.connectivity.presentation.auth.AuthViewModel


@Composable
fun ConnectivityApp( requestPayment: () -> Unit) {
    val authViewModel = viewModel { AuthViewModel() }

    val coroutineScope = rememberCoroutineScope()

    authViewModel.checkAuth()

    Main(authViewModel, requestPayment)

}