package com.ixperta.android.connectivity.infrastructure.mocks

import arrow.core.Either
import com.ixperta.android.connectivity.domain.token.entity.TokenEntity
import com.ixperta.android.connectivity.domain.token.repository.TokenRepository
import com.ixperta.android.connectivity.domain.token.values.Token

class MockedTokenRepository : TokenRepository {
    override fun getCurrentToken(): Either<Unit, TokenEntity> {
        return Either.Right(TokenEntity(Token("FakeToken123456")))
    }
}