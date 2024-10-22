package com.ixperta.android.connectivity.infrastructure.mocks

import arrow.core.Either
import com.ixperta.android.connectivity.domain.user.entity.UserEntity
import com.ixperta.android.connectivity.domain.user.repository.UserAuthRepository

class MockedUserAuthRepository:UserAuthRepository {
    override fun authUser(user: UserEntity): Either<Unit, Boolean> {
       return Either.Right(true)
    }
}