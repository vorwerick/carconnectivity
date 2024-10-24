package com.ixperta.android.connectivity.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.ixperta.android.connectivity.configuration.app.AppConfig
import com.ixperta.android.connectivity.presentation.auth.AuthViewModel
import com.ixperta.android.connectivity.presentation.car.CarViewModel
import com.ixperta.android.connectivity.presentation.car.SubscriptionPlans
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlanViewModel
import com.ixperta.android.connectivity.ui.components.StatusBadge
import com.ixperta.android.connectivity.ui.components.SubscriptionCard
import com.ixperta.android.connectivity.ui.components.Toolbar
import com.ixperta.android.connectivity.ui.styles.AppColors
import com.ixperta.android.connectivity.ui.utils.BadgeByPlan

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SubscriptionScreen(
    navController: NavHostController,
    carViewModel: CarViewModel,
    authViewModel: AuthViewModel,
    appConfig: AppConfig
) {
    val plan = carViewModel.plan.collectAsState()
    val subscriptionPlanViewModel: SubscriptionPlanViewModel =
        viewModel { SubscriptionPlanViewModel() }
    LaunchedEffect("fetch") {
        subscriptionPlanViewModel.fetchPlans()
    }
    val plans = subscriptionPlanViewModel.plans.collectAsState()
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
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {

            var index = 0
            plans.value.map {
                var currentPlan = SubscriptionPlans.free
                if (index == 0) {
                    currentPlan = SubscriptionPlans.free
                }
                if (index == 1) {
                    currentPlan = SubscriptionPlans.basic
                }
                if (index == 2) {
                    currentPlan = SubscriptionPlans.advanced
                }
                if (index == 3) {
                    currentPlan = SubscriptionPlans.premium
                }
                SubscriptionCard(
                    it.priceMonthly,
                    it.priceUnit,
                    {
                        BadgeByPlan(currentPlan)
                    },
                    it.subtitle,
                    navController,
                    currentPlan,
                    carViewModel.plan.value,
                    appConfig,
                    carViewModel,
                    authViewModel,
                    )
                index++
            }


        }
    }


}

