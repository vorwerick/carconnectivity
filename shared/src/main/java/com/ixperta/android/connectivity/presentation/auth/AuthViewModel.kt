package com.ixperta.android.connectivity.presentation.auth

import androidx.lifecycle.ViewModel
import com.ixperta.android.connectivity.domain.user.repository.UserAuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel(): ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.NotInitialized)
    val authState: StateFlow<AuthState> = _authState


    fun login(user: String, password: String) {
        _authState.value = AuthState.Logged
    }

    fun logout() {
        _authState.value = AuthState.Unlogged
    }

    fun checkAuth() {
        //get user credentials
        _authState.value = AuthState.Unlogged
    }
}