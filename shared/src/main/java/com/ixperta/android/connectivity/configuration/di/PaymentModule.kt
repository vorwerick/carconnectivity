package com.ixperta.android.connectivity.configuration.di

import com.ixperta.android.connectivity.application.payment.CheckIsReadyToPay
import com.ixperta.android.connectivity.application.payment.CreatePaymentsClient
import com.ixperta.android.connectivity.application.payment.LoadPaymentData
import com.ixperta.android.connectivity.application.payment.PayConfig
import com.ixperta.android.connectivity.configuration.payment.DefaultPayConfig
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val paymentModule = module {
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

}