package com.ixperta.android.connectivity.configuration.di

import com.ixperta.android.connectivity.domain.catalog.repository.CatalogRepository
import com.ixperta.android.connectivity.domain.user.repository.UserAuthRepository
import com.ixperta.android.connectivity.domain.user.repository.UserRepository
import com.ixperta.android.connectivity.domain.vehicle.repository.VehicleRepository
import com.ixperta.android.connectivity.infrastructure.catalog.DemoCatalogRepository
import com.ixperta.android.connectivity.infrastructure.mocks.MockedUserAuthRepository
import com.ixperta.android.connectivity.infrastructure.user.FakeUserRepository
import com.ixperta.android.connectivity.infrastructure.vehicle.DemoVehicleRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val repositoryModule = module {

    //repositories
    factoryOf(::MockedUserAuthRepository) { bind<UserAuthRepository>() }

    factoryOf(::FakeUserRepository) { bind<UserRepository>() }

    factoryOf(::DemoVehicleRepository) { bind<VehicleRepository>() }
    factoryOf(::DemoCatalogRepository) { bind<CatalogRepository>() }

}