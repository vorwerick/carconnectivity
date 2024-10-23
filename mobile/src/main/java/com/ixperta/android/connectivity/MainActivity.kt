package com.ixperta.android.connectivity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.wallet.contract.TaskResultContracts
import com.ixperta.android.connectivity.application.payment.CheckIsReadyToPay
import com.ixperta.android.connectivity.application.payment.LoadPaymentData
import com.ixperta.android.connectivity.presentation.payment.CheckoutViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get

class MainActivity : ComponentActivity() {
    private val tag = "MainActivity"
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

//        // example for payment
//        val checkPayment: CheckIsReadyToPay = get()
//        val loadPaymentData: LoadPaymentData = get()
//
//        CoroutineScope(Dispatchers.Main).launch{
//            // This one will help to check if you can show pay button
//            val result = checkPayment.execute()
//            Log.d(tag,"Can you make payment: $result")
//
//            /// This one will help to invoke payment dialog
//            loadPaymentData.execute(532).addOnCompleteListener(paymentDataLauncher::launch)
//
//        }


    }


    private fun requestPayment() {
        val task = model.getLoadPaymentDataTask(priceCents = 1000L)
        task.addOnCompleteListener(paymentDataLauncher::launch)
    }

}
