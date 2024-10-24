package com.ixperta.android.connectivity.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.ixperta.android.connectivity.configuration.app.AppConfig
import com.ixperta.android.connectivity.presentation.auth.AuthViewModel
import com.ixperta.android.connectivity.presentation.car.CarViewModel
import com.ixperta.android.connectivity.presentation.car.SubscriptionPlans
import com.ixperta.android.connectivity.presentation.payment.CheckoutViewModel
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlanViewModel
import com.ixperta.android.connectivity.ui.styles.AppColors
import kotlinx.coroutines.launch

@Composable
fun SubscriptionCard(
    priceCents: Int,
    currency: String,
    badge: @Composable () -> Unit,
    notes: String,
    navHostController: NavHostController,
    subscriptionPlan: SubscriptionPlans,
    currentSubscriptionPlan: SubscriptionPlans,
    appConfig: AppConfig,
    carViewModel: CarViewModel,
    authViewModel: AuthViewModel,
    checkoutViewModel: CheckoutViewModel = viewModel(),

    ) {
    val scope = rememberCoroutineScope()
    Card(
        backgroundColor = AppColors.carItemBackground,
        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
        shape = RoundedCornerShape(10),
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            badge()
            Spacer(Modifier.height(6.dp))
            Text(
                "${priceCents.toString()} ${currency}",
                fontSize = 42.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(12.dp))
            Text(notes, color = AppColors.carItemTitleColor, fontSize = 16.sp)

            Spacer(Modifier.height(12.dp))

            if (subscriptionPlan == currentSubscriptionPlan) {
                Text(
                    "Your current plan",
                    fontSize = 22.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

            } else {
                GreenButton({
                    scope.launch {
                        appConfig.paymentDataLauncher?.also {
                            checkoutViewModel.requestPayment(
                                priceCents.toLong() ?: 100.toLong(), it
                            )
                            carViewModel.boughtPlan(
                                subscriptionPlan,
                                authViewModel.currentUser.value!!
                            )
                            navHostController.popBackStack()
                        }
                    }

                }, "Upgrade")
            }


        }

    }


}