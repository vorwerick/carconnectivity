package com.ixperta.android.connectivity.domain.user.repository

import arrow.core.Either
import com.ixperta.android.connectivity.domain.user.entity.UserEntity

interface UserAuthRepository {
    fun authUser(user: UserEntity): Either<Unit, Boolean>
}