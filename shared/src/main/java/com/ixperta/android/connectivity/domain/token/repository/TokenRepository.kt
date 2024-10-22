package com.ixperta.android.connectivity.domain.token.repository

import arrow.core.Either
import com.ixperta.android.connectivity.domain.token.entity.TokenEntity

interface TokenRepository {

    fun getCurrentToken(): Either<Unit, TokenEntity>

}