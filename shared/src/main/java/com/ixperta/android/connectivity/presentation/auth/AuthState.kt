package com.ixperta.android.connectivity.presentation.auth


sealed class AuthState {

    data object NotInitialized : AuthState()
    data object Logged : AuthState()
    data object Unlogged : AuthState()
}

