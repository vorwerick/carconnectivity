package com.ixperta.android.connectivity.configuration.di

import com.ixperta.android.connectivity.domain.token.repository.TokenRepository
import com.ixperta.android.connectivity.domain.user.repository.UserAuthRepository
import com.ixperta.android.connectivity.domain.vehicle.repository.VehicleRepository
import com.ixperta.android.connectivity.infrastructure.mocks.*
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module


val appModule = module {
    factoryOf(::MockedUserAuthRepository) { bind<UserAuthRepository>() }
    factoryOf(::MockedVehicleRepository) {bind<VehicleRepository>()}
    factoryOf(::MockedTokenRepository) {bind<TokenRepository>()}

}