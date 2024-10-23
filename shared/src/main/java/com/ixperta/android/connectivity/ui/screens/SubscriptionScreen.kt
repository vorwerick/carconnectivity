package com.ixperta.android.connectivity.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.ixperta.android.connectivity.ui.components.StatusBadge
import com.ixperta.android.connectivity.ui.components.SubscriptionCard
import com.ixperta.android.connectivity.ui.components.Toolbar
import com.ixperta.android.connectivity.ui.styles.AppColors

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SubscriptionScreen(navController: NavHostController, requestPayment: () -> Unit) {
    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .padding(),
        topBar = {
            Toolbar("Subscription plan") {
                navController.popBackStack()
            }
        },
    ) {

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            SubscriptionCard(
                "$3",
                { StatusBadge("Basic", AppColors.redBadgeColor) },
                listOf("blaba", "balba")
            ) {
                requestPayment.invoke()
            }
            SubscriptionCard("$6", { StatusBadge("Basic", AppColors.redBadgeColor) }, listOf("blaba", "balba")) {
                requestPayment.invoke()
            }
            SubscriptionCard("$9", { StatusBadge("Basic", AppColors.redBadgeColor) }, listOf("blaba", "balba")) {
                requestPayment.invoke()
            }
            SubscriptionCard("$12", { StatusBadge("Basic", AppColors.redBadgeColor) }, listOf("blaba", "balba")) {
                requestPayment.invoke()
            }
        }
    }


}

