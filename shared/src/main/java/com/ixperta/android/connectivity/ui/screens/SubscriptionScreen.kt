package com.ixperta.android.connectivity.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.ixperta.android.connectivity.AppConfig
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlanViewModel
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlans
import com.ixperta.android.connectivity.ui.components.StatusBadge
import com.ixperta.android.connectivity.ui.components.SubscriptionCard
import com.ixperta.android.connectivity.ui.components.Toolbar
import com.ixperta.android.connectivity.ui.styles.AppColors

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SubscriptionScreen(
    navController: NavHostController,
    subscriptionPlanViewModel: SubscriptionPlanViewModel,
    appConfig: AppConfig
) {
    val currentSubscription = subscriptionPlanViewModel.subscriptionPlan.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        backgroundColor = AppColors.background,
        modifier = Modifier
            .fillMaxWidth()
            .padding(),
        topBar = {
            Toolbar("Pricing") {
                navController.popBackStack()
            }
        },
    ) {

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {

            SubscriptionCard(
                0,
                { StatusBadge("FREE", Color.Cyan) },
                listOf("Remote services"),
                navController,
                SubscriptionPlans.FREE,
                currentSubscription.value,
                appConfig
            )
            SubscriptionCard(
                4.20.toLong(),
                { StatusBadge("ADVANCED", Color.Magenta) },
                listOf(
                    "Remote services",
                    "Full vehicle status",
                    "Vehicle remote control",
                    "Mobile payments",
                ),
                navController,
                SubscriptionPlans.ADVANCED,
                currentSubscription.value,
                appConfig
            )
            SubscriptionCard(
                5.15.toLong(),
                { StatusBadge("PREMIUM", Color.Yellow) },
                listOf(
                    "Remote services",
                    "Full vehicle status",
                    "Vehicle remote control",
                    "Mobile payments",
                    "In-car live voice control",
                    "2 GB in-car data with hotspot"
                ),
                navController,
                SubscriptionPlans.PREMIUM,
                currentSubscription.value,
                appConfig
            )

        }
    }


}

