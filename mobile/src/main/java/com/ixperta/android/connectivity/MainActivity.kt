package com.ixperta.android.connectivity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.wallet.contract.TaskResultContracts
import com.ixperta.android.connectivity.presentation.payment.CheckoutViewModel

class MainActivity : ComponentActivity() {

    private val paymentDataLauncher = registerForActivityResult(TaskResultContracts.GetPaymentDataResult()) { taskResult ->
        when (taskResult.status.statusCode) {
            CommonStatusCodes.SUCCESS -> {
                taskResult.result!!.let {
                    Log.i("Google Pay result:", it.toJson())
                    model.setPaymentData(it)
                }
            }
            //CommonStatusCodes.CANCELED -> The user canceled
            //CommonStatusCodes.DEVELOPER_ERROR -> The API returned an error (it.status: Status)
            else ->  Log.i("Google Pay result:", taskResult.status.statusMessage ?: "")
        }
    }

    private val model: CheckoutViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)


        setContent {
            ConnectivityApp(::requestPayment)
        }
    }


    private fun requestPayment() {
        val task = model.getLoadPaymentDataTask(priceCents = 1000L)
        task.addOnCompleteListener(paymentDataLauncher::launch)
    }

}
