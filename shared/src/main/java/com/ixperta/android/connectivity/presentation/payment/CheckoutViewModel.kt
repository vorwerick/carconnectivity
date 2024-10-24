package com.ixperta.android.connectivity.presentation.payment

import android.app.Application
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.AndroidViewModel
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.Task
import com.google.android.gms.wallet.PaymentData
import com.google.android.gms.wallet.PaymentsClient
import com.ixperta.android.connectivity.application.payment.CheckIsReadyToPay
import com.ixperta.android.connectivity.application.payment.LoadPaymentData

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import org.koin.java.KoinJavaComponent.get

class CheckoutViewModel(application: Application) : AndroidViewModel(application) {


    private val paymentDataLauncher = MutableStateFlow<ActivityResultLauncher<Task<PaymentData>>?>(null)

    init {
        Log.d("CheckoutViewModel", "NEW")
    }

    suspend fun requestPayment(priceCents: Long,paymentDataLauncher: ActivityResultLauncher<Task<PaymentData>>) {
        val checkPayment: CheckIsReadyToPay = get(CheckIsReadyToPay::class.java)
        val loadPaymentData: LoadPaymentData = get(LoadPaymentData::class.java)
        Log.d("CheckoutViewModel", "GOGOG")

        paymentDataLauncher.also {
            Log.d("CheckoutViewModel", "CUCU")

            val result = checkPayment.execute()
            Log.d("CheckoutViewModel", "Can you make payment: $result")

            /// This one will help to invoke payment dialog
            loadPaymentData.execute(priceCents).addOnCompleteListener(it::launch)
        }

    }

    fun onSuccessPayment(paymentData: PaymentData) {
        //todo send info to server about plan change
    }

}

