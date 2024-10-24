package com.ixperta.android.connectivity.domain.user.repository

import com.ixperta.android.connectivity.domain.user.entity.UserEntity

interface UserRepository {
    fun getCurrentUser(): UserEntity

}