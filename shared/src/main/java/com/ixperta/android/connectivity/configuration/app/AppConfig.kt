package com.ixperta.android.connectivity.configuration.app

import androidx.activity.result.ActivityResultLauncher
import com.google.android.gms.tasks.Task
import com.google.android.gms.wallet.PaymentData

data class AppConfig(
    val isAutomotiveOS: Boolean,
    val paymentDataLauncher: (ActivityResultLauncher<Task<PaymentData>>)? = null
) {

}