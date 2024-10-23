package com.ixperta.android.connectivity.application.payment


import com.google.android.gms.wallet.IsReadyToPayRequest
import com.ixperta.android.connectivity.application.UseCaseAsync
import com.ixperta.android.connectivity.presentation.payment.awaitTask

class CheckIsReadyToPay(
    private val config: PayConfig,
    private val createClient: CreatePaymentsClient
) : UseCaseAsync<Boolean> {
    override suspend fun execute(): Boolean {
        val isReadyToPayJson = config.createIsReadyToPayRequest() ?: return false
        val request = IsReadyToPayRequest.fromJson(isReadyToPayJson.toString())

        val client = createClient.execute()

        val task = client.isReadyToPay(request).awaitTask()
        return task.result


    }
}