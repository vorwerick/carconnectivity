package com.ixperta.android.connectivity.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.ixperta.android.connectivity.presentation.auth.AuthViewModel
import com.ixperta.android.connectivity.presentation.car.CarViewModel
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlanViewModel
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlans
import com.ixperta.android.connectivity.shared.R
import com.ixperta.android.connectivity.ui.components.Toolbar
import com.ixperta.android.connectivity.ui.components.UpgradeBox
import com.ixperta.android.connectivity.ui.styles.AppColors

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun VehicleStatusScreen(
    navController: NavHostController,
    subscriptionPlanViewModel: SubscriptionPlanViewModel,
    authViewModel: AuthViewModel, carViewModel: CarViewModel = viewModel()
) {

    val carLocked = carViewModel.vehicleStatusLocked.collectAsState()
    val currentSubscription = subscriptionPlanViewModel.subscriptionPlan.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val isFree = currentSubscription.value == SubscriptionPlans.FREE
    Scaffold(
        backgroundColor = AppColors.background,
        modifier = Modifier
            .fillMaxWidth()
            .padding(),
        topBar = {
            Toolbar("Vehicle status") {
                navController.popBackStack()
            }
        },
    ) {
        Box() {
            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.car),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp)


                )

                Row(horizontalArrangement = Arrangement.Center) {
                    Text(
                        "Vehicle is ${(if (carLocked.value == true) "locked" else "unlocked")}",
                        color = AppColors.carItemTitleColor,
                        fontWeight = FontWeight(600),
                        fontSize = 18.sp
                    )

                }
                Switch(
                    enabled = !isFree,
                    checked = carLocked.value ?: false,
                    onCheckedChange = { va ->
                        carViewModel.setLockedState(va)
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = AppColors.skodaGreenColor,
                        checkedTrackColor = AppColors.carItemTitleColor,
                        uncheckedTrackColor = AppColors.carItemBackground
                    )
                )

            }
            if (isFree)
                Box(modifier = Modifier.align(Alignment.BottomCenter)) {
                    UpgradeBox(navController, "Upgrade to lock or unlock your car from anywhere")
                }
        }


    }
}