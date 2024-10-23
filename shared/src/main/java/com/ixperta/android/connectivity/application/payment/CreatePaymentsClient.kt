package com.ixperta.android.connectivity.application.payment

import android.content.Context
import com.google.android.gms.wallet.PaymentsClient
import com.google.android.gms.wallet.Wallet
import com.ixperta.android.connectivity.application.UseCase

class CreatePaymentsClient(private val context: Context, private val config: PayConfig) :
    UseCase<PaymentsClient> {

    override  fun execute(): PaymentsClient {
        val walletOption = config.createWalletOption()
        return Wallet.getPaymentsClient(context, walletOption)
    }
}