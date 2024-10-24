package com.ixperta.android.connectivity.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.ixperta.android.connectivity.presentation.car.CarType
import com.ixperta.android.connectivity.presentation.car.CarViewModel
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlanViewModel
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlans
import com.ixperta.android.connectivity.shared.R
import com.ixperta.android.connectivity.ui.components.car.CarInfoItem
import com.ixperta.android.connectivity.ui.components.car.CarTitleText
import com.ixperta.android.connectivity.ui.nav.Route
import com.ixperta.android.connectivity.ui.styles.AppColors

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "ResourceType")
@Composable
fun CarScreen(
    carViewModel: CarViewModel,
    navController: NavHostController,
    subscriptionPlanViewModel: SubscriptionPlanViewModel
) {
    LaunchedEffect("") {
        carViewModel.fetchData()
    }

    val carNameState by carViewModel.carName.collectAsState()
    val vehicleStatusLocked by carViewModel.vehicleStatusLocked.collectAsState()
    val batteryState by carViewModel.batteryState.collectAsState()
    val temperature by carViewModel.temperature.collectAsState()
    val chargingLocation by carViewModel.chargingLocation.collectAsState()
    val carType by carViewModel.carType.collectAsState()

    val subscriptionPlan by subscriptionPlanViewModel.subscriptionPlan.collectAsState()
    val isFree = subscriptionPlan == SubscriptionPlans.FREE

    Scaffold(backgroundColor = AppColors.background) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            CarTitleText(carNameState)
            carType?.also {
                if (it == CarType.CAR1)
                    Image(
                        painter = painterResource(R.drawable.octavia),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(256.dp)

                    )
                if (it == CarType.CAR2)
                    Image(
                        painter = painterResource(R.drawable.octavia),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(256.dp)

                    )
            }


            CarInfoItem("Vehicle status", subscriptionPlan, {
                Row(modifier = Modifier.padding(start = 24.dp, bottom = 16.dp, top = 8.dp)) {
                    Icon(
                        Icons.Default.Lock,
                        "",
                        modifier = Modifier,
                        tint = AppColors.textWhiteColor
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        getStatusTitle(vehicleStatusLocked),
                        fontSize = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight(600),
                    )
                }
            }, "Upgrade") {
                navController.navigate(Route.VehicleStatus.route)
            }
            CarInfoItem("Battery", subscriptionPlan, {
                Row(modifier = Modifier.padding(start = 24.dp, bottom = 16.dp, top = 8.dp)) {
                    Icon(
                        Icons.Outlined.Info,
                        "",
                        modifier = Modifier,
                        tint = AppColors.textWhiteColor
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        batteryState ?: "",
                        fontSize = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight(600),
                    )
                }


            }, "Upgrade") {
                navController.navigate(Route.Range.route)
            }
            CarInfoItem("Target temperature", subscriptionPlan, {
                var modifier = Modifier.blur(10.dp)
                if (subscriptionPlan != SubscriptionPlans.FREE)
                    modifier = Modifier.blur(0.dp)
                Box(modifier) {
                    Text(
                        "$temperature °C ",
                        fontSize = 24.sp,
                        fontWeight = FontWeight(600),
                        color = Color.White,

                        modifier = Modifier.padding(start = 24.dp, bottom = 16.dp, top = 8.dp)
                    )
                }
            }, "Upgrade") {
                navController.navigate(Route.ClimateControl.route)
            }
            CarInfoItem("Charging location", subscriptionPlan, {
                var modifier = Modifier.blur(10.dp)
                if (subscriptionPlan != SubscriptionPlans.FREE)
                    modifier = Modifier.blur(0.dp)
                Box(modifier) {
                    Text(
                        "${chargingLocation} " ?: "",
                        fontSize = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight(600),
                        modifier = Modifier.padding(start = 24.dp, bottom = 16.dp, top = 8.dp)
                    )
                }
            }, null,null)
        }
    }
}

fun getStatusTitle(status: Boolean?): String {
    if (status == true) {
        return "Locked"
    } else {
        return "Unlocked"
    }
}
