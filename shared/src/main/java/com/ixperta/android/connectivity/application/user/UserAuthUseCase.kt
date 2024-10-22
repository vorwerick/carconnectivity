package com.ixperta.android.connectivity.application.user

import com.ixperta.android.connectivity.application.UseCase
import com.ixperta.android.connectivity.domain.user.entity.UserEntity
import com.ixperta.android.connectivity.domain.user.repository.UserAuthRepository

class UserAuthUseCase(
    private val user: UserEntity,
    private val authRepository: UserAuthRepository
) :
    UseCase<Boolean> {
    override fun execute(): Boolean {
        val result = authRepository.authUser(user)
        return result.fold({ false }, { it })
    }
}