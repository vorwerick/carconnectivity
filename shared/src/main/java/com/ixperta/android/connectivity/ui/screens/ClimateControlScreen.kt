package com.ixperta.android.connectivity.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun ClimateControlScreen(
    navController: NavHostController,
    subscriptionPlanViewModel: SubscriptionPlanViewModel,
    authViewModel: AuthViewModel, carViewModel: CarViewModel = viewModel()
) {
    LaunchedEffect("") {
        carViewModel.fetchData()
    }
    val currentSubscription = subscriptionPlanViewModel.subscriptionPlan.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val temperature = carViewModel.temperature.collectAsState()
    val isFree = currentSubscription.value == SubscriptionPlans.FREE
    Scaffold(
        backgroundColor = AppColors.background,
        modifier = Modifier
            .fillMaxWidth()
            .padding(),
        topBar = {
            Toolbar("Climate control") {
                navController.popBackStack()
            }
        },
    ) {
        Box() {
            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box() {
                    Image(
                        painter = painterResource(R.drawable.progress),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(320.dp)


                    )
                    Box(Modifier.align(Alignment.Center)) {
                        Row(horizontalArrangement = Arrangement.Center) {
                            if (!isFree)
                                IconButton(
                                    {
                                        carViewModel.decreaseTemperature()
                                    },
                                ) {
                                    Icon(
                                        Icons.Default.KeyboardArrowDown,
                                        "add",
                                        tint = Color.White,
                                        modifier = Modifier
                                            .background(AppColors.carItemBackground)
                                            .padding(6.dp)
                                    )
                                }
                            Spacer(Modifier.width(8.dp))
                            Text(
                                "${temperature.value} °C",
                                color = Color.White,

                                fontSize = 36.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(Modifier.width(8.dp))
                            if (!isFree)
                                IconButton({
                                    carViewModel.increaseTemperature()
                                }) {
                                    Icon(
                                        Icons.Default.KeyboardArrowUp,
                                        "remove",
                                        tint = Color.White,
                                        modifier = Modifier
                                            .background(AppColors.carItemBackground)
                                            .padding(6.dp)
                                    )
                                }
                        }
                    }
                }


            }
            if (isFree)
                Box(modifier = Modifier.align(Alignment.BottomCenter)) {
                    UpgradeBox(navController, "Upgrade to set your car temperature from anywhere")
                }
        }


    }
}