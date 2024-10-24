package com.ixperta.android.connectivity.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlanViewModel
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlans
import com.ixperta.android.connectivity.ui.components.car.InspectCarItem
import com.ixperta.android.connectivity.ui.styles.AppColors

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun InspectScreen(
    navController: NavHostController,
    subscriptionPlanViewModel: SubscriptionPlanViewModel
) {
    val subscriptionPlanState = subscriptionPlanViewModel.subscriptionPlan.collectAsState()
    val isFree = subscriptionPlanState.value == SubscriptionPlans.FREE
    Scaffold(backgroundColor = AppColors.background, topBar = {}) {

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Box(
                Modifier
                    .fillMaxWidth()) {
                Text(
                    "Inspect",
                    modifier = Modifier.padding(start = 24.dp, top = 32.dp, bottom = 32.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                )

            }
            InspectCarItem(
                "Vehicle Health",
                "All good",
                if (isFree) "Upgrade" else null,
                Icons.Default.Lock,
                isFree,
                navController
            )
            InspectCarItem(
                "Service",
                "Car data & my service partner",
                if (isFree) "Upgrade" else null,
                Icons.Default.Lock,
                isFree,
                navController
            )
            InspectCarItem(
                "Assistance",
                "Call for help",
                if (isFree) "Upgrade" else null,
                Icons.Default.Lock,
                isFree,
                navController
            )
            InspectCarItem(
                "Car details",
                "More info about your car",
                if (isFree) "Upgrade" else null,
                Icons.Default.Lock,
                isFree,
                navController
            )
        }
    }
}