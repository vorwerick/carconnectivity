package com.ixperta.android.connectivity.presentation.auth

import androidx.lifecycle.ViewModel
import com.ixperta.android.connectivity.application.payment.CheckIsReadyToPay
import com.ixperta.android.connectivity.application.user.UserAuthUseCase
import com.ixperta.android.connectivity.domain.user.entity.UserEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.java.KoinJavaComponent.get

class AuthViewModel(): ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Unlogged)
    val authState: StateFlow<AuthState> = _authState

    private val _error = MutableStateFlow<Boolean>(false)
    val error: StateFlow<Boolean> = _error

    private val _currentUser = MutableStateFlow<String?>(null)
    val currentUser: StateFlow<String?> = _currentUser


     fun login(user: String, password: String) {
         _error.value = false
        val userAuthUseCase: UserAuthUseCase = get(UserAuthUseCase::class.java)
        val result = userAuthUseCase.execute(UserEntity(user))

        if(result){
            _authState.value = AuthState.Logged
            _currentUser.value = user
        } else {
            _error.value = true
            _authState.value = AuthState.Unlogged
        }

    }

    fun logout() {
        _authState.value = AuthState.Unlogged
        _currentUser.value = null
    }

    fun checkAuth() {
        //get user credentials
        _authState.value = AuthState.Unlogged
    }
}