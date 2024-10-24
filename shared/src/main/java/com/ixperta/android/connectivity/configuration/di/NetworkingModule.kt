package com.ixperta.android.connectivity.configuration.di

import com.ixperta.android.connectivity.configuration.api.NetworkConfig
import com.ixperta.android.connectivity.infrastructure.api.client.DemoClient
import com.ixperta.android.connectivity.infrastructure.api.client.authorization.DemoBasicAuthInterceptor
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val networkingModule = module {
    // Networking
    factoryOf(::NetworkConfig) { bind<NetworkConfig>() }

    factory {
        DemoBasicAuthInterceptor(get())
    }

    factory {
        DemoClient(get(), get()).createService()
    }
}