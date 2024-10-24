package com.ixperta.android.connectivity.configuration.di

import com.ixperta.android.connectivity.presentation.payment.CheckoutViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    //view models
    viewModel { CheckoutViewModel(androidApplication()) }
}