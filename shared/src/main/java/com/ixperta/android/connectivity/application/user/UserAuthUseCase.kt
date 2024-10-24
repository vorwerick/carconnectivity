package com.ixperta.android.connectivity.application.user

import com.ixperta.android.connectivity.application.UseCase
import com.ixperta.android.connectivity.application.UseCaseWith
import com.ixperta.android.connectivity.domain.user.entity.UserEntity
import com.ixperta.android.connectivity.domain.user.repository.UserAuthRepository

class UserAuthUseCase(
    private val authRepository: UserAuthRepository
) :
    UseCaseWith<Boolean, UserEntity> {
    override fun execute(value: UserEntity): Boolean {
        val result = authRepository.authUser(value)
        return result.fold({ false }, { it })
    }
}