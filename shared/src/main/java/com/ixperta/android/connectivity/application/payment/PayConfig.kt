package com.ixperta.android.connectivity.application.payment

import com.google.android.gms.wallet.Wallet.WalletOptions
import org.json.JSONObject

interface PayConfig {

    fun createWalletOption(): WalletOptions

    fun createIsReadyToPayRequest(): JSONObject?

    fun createPaymentDataRequest(priceCents: Long): JSONObject


}