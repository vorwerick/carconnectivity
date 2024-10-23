package com.ixperta.android.connectivity.application.payment

import com.google.android.gms.tasks.Task
import com.google.android.gms.wallet.PaymentData
import com.google.android.gms.wallet.PaymentDataRequest
import com.ixperta.android.connectivity.application.UseCaseWith

class LoadPaymentData(
    private val config: PayConfig,
    private val createClient: CreatePaymentsClient
) : UseCaseWith<Task<PaymentData>, Long> {

    override fun execute(value: Long): Task<PaymentData> {
        val paymentRequest = config.createPaymentDataRequest(value)
        val request = PaymentDataRequest.fromJson(paymentRequest.toString())

        val client = createClient.execute()

        return client.loadPaymentData(request)

    }
}