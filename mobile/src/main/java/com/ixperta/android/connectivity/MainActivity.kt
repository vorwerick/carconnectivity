package com.ixperta.android.connectivity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.wallet.contract.TaskResultContracts
import com.ixperta.android.connectivity.configuration.app.AppConfig
import com.ixperta.android.connectivity.presentation.payment.CheckoutViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    
    private val tag = "MainActivity"
    private val paymentDataLauncher =
        registerForActivityResult(TaskResultContracts.GetPaymentDataResult()) { taskResult ->
            when (taskResult.status.statusCode) {
                CommonStatusCodes.SUCCESS -> {
                    taskResult.result!!.let {
                        Log.i("Google Pay result:", it.toJson())
                        getViewModel<CheckoutViewModel>().onSuccessPayment(it)

                    }
                }
                //CommonStatusCodes.CANCELED -> The user canceled
                //CommonStatusCodes.DEVELOPER_ERROR -> The API returned an error (it.status: Status)
                else -> Log.i("Google Pay result:", taskResult.status.statusMessage ?: "")
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val appConfig = AppConfig(false, paymentDataLauncher)


        setContent {
            if (appConfig.isAutomotiveOS) {
                ConnectivityAppAutomotive(appConfig)

            } else {
                ConnectivityApp(appConfig)

            }
        }

    }


}
