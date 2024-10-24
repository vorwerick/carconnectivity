package com.ixperta.android.connectivity.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ixperta.android.connectivity.presentation.auth.AuthViewModel
import com.ixperta.android.connectivity.presentation.car.CarType
import com.ixperta.android.connectivity.presentation.car.CarViewModel
import com.ixperta.android.connectivity.presentation.car.SubscriptionPlans
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlanViewModel
import com.ixperta.android.connectivity.shared.R
import com.ixperta.android.connectivity.ui.components.car.CarDetailItem
import com.ixperta.android.connectivity.ui.nav.Route
import com.ixperta.android.connectivity.ui.styles.AppColors

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
    navController: NavHostController,
    carViewModel: CarViewModel,
    subscriptionPlanViewModel: SubscriptionPlanViewModel,
    authViewModel: AuthViewModel
) {

    val carName by carViewModel.carName.collectAsState()
    val carType by carViewModel.carType.collectAsState()
    val vin by carViewModel.vin.collectAsState()

    val subscriptionPlan by carViewModel.plan.collectAsState()

    Scaffold(backgroundColor = AppColors.background, topBar = {}) {

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Box(
                Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    "Car details",
                    modifier = Modifier.padding(start = 24.dp, top = 32.dp, bottom = 32.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                )

            }
            carType?.also {
                if (it == CarType.CAR1)
                    Image(
                        painter = painterResource(R.drawable.octavia_detail),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(192.dp)

                    )
                if (it == CarType.CAR2)
                    Image(
                        painter = painterResource(R.drawable.octavia_detail),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(192.dp)

                    )
            }
            CarDetailItem("Car name", carName)
            CarDetailItem("Current plan", subscriptionPlan.toString(), {
                navController.navigate(Route.SubscriptionPlans.route)
            }, if (subscriptionPlan == SubscriptionPlans.free) "Upgrade" else null)
            CarDetailItem("Model", "Coupe")
            CarDetailItem("Trim level", "RS")
            CarDetailItem("VIN", vin)
            CarDetailItem("Number plate", "4A1 9391")
            CarDetailItem("Mileage", "320 032 km")
            CarDetailItem("Max performance", "150 kW")
            CarDetailItem("User", "Log out", {
                authViewModel.logout()
            })

        }
    }
}