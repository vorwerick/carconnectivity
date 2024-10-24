package com.ixperta.android.connectivity.infrastructure.mocks

import arrow.core.Either
import com.ixperta.android.connectivity.domain.user.entity.UserEntity
import com.ixperta.android.connectivity.domain.user.repository.UserAuthRepository

class MockedUserAuthRepository : UserAuthRepository {

    val mockedUserList by lazy {
        listOf(
            "miroslav.vinter@skoda-auto.cz",
            "tomas.stary@ixperta.com"
        )
    }

    override fun authUser(user: UserEntity): Either<Unit, Boolean> {

        return Either.Right(mockedUserList.contains(user.email))
    }
}