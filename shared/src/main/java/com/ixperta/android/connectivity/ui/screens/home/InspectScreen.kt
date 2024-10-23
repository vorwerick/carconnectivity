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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlanViewModel
import com.ixperta.android.connectivity.ui.components.car.InspectCarItem
import com.ixperta.android.connectivity.ui.nav.Route

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun InspectScreen(
    navController: NavHostController,
    subscriptionPlanViewModel: SubscriptionPlanViewModel
) {
    Scaffold(backgroundColor = Color.Black, topBar = {}) {

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Box(
                Modifier
                    .background(Color.Black)
                    .fillMaxWidth()) {
                Text(
                    "Inspect",
                    modifier = Modifier.padding(start = 24.dp, top = 32.dp, bottom = 32.dp),
                    color = Color.White,
                    fontSize = 32.sp,
                )

            }
            InspectCarItem(
                "Driving data",
                "View your driving statistics",
                "Locked",
                Icons.Default.Lock
            ) {
                navController.navigate(Route.SubscriptionPlans.route)
            }
            InspectCarItem("Vehicle health report", "All good", "Locked", Icons.Default.Lock) {

            }
            InspectCarItem(
                "Service",
                "Car data & my service partner",
                "Locked",
                Icons.Default.Lock
            ) {

            }
            InspectCarItem(
                "Car details",
                "More info about your car",
                "Locked",
                Icons.Default.Lock
            ) {

            }
            InspectCarItem(
                "Digital manual",
                "Discover more features",
                "Locked",
                Icons.Default.Lock
            ) {

            }
        }
    }
}