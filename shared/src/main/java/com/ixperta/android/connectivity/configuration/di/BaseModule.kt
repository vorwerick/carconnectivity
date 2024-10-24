package com.ixperta.android.connectivity.configuration.di

import com.ixperta.android.connectivity.application.UseCase
import com.ixperta.android.connectivity.application.payment.CheckIsReadyToPay
import com.ixperta.android.connectivity.application.payment.CreatePaymentsClient
import com.ixperta.android.connectivity.application.payment.LoadPaymentData
import com.ixperta.android.connectivity.application.payment.PayConfig
import com.ixperta.android.connectivity.configuration.payment.DefaultPayConfig
import com.ixperta.android.connectivity.domain.token.repository.TokenRepository
import com.ixperta.android.connectivity.domain.user.repository.UserAuthRepository
import com.ixperta.android.connectivity.domain.vehicle.repository.VehicleRepository
import com.ixperta.android.connectivity.infrastructure.mocks.*
import com.ixperta.android.connectivity.presentation.payment.CheckoutViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    //repositories
    factoryOf(::MockedUserAuthRepository) { bind<UserAuthRepository>() }
    factoryOf(::MockedVehicleRepository) { bind<VehicleRepository>() }
    factoryOf(::MockedTokenRepository) { bind<TokenRepository>() }

    //payment
    singleOf(::DefaultPayConfig) { bind<PayConfig>() }
    factory {
        CreatePaymentsClient(androidContext(), get())
    }
    factory {
        CheckIsReadyToPay(get(), get())
    }
    factory {
        LoadPaymentData(get(), get())
    }


    //view models
    viewModel { CheckoutViewModel(androidApplication()) }
}