package com.ixperta.android.connectivity.infrastructure.client

import android.content.Context
import com.google.android.gms.common.internal.Constants
import com.google.android.gms.wallet.PaymentsClient
import com.google.android.gms.wallet.Wallet

class PaymentClient{
    fun createPaymentsClient(context: Context): PaymentsClient {
        val walletOptions = Wallet.WalletOptions.Builder()
            .setEnvironment(0)
            .build()

        return Wallet.getPaymentsClient(context, walletOptions)
    }
}