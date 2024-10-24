package com.ixperta.android.connectivity.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
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
fun RangeScreen(
    navController: NavHostController,
    subscriptionPlanViewModel: SubscriptionPlanViewModel,
    authViewModel: AuthViewModel, carViewModel: CarViewModel = viewModel()
) {
    LaunchedEffect("") {
        carViewModel.fetchData()
    }
    val range = carViewModel.carRange.collectAsState()
    val currentSubscription = subscriptionPlanViewModel.subscriptionPlan.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val isFree = currentSubscription.value == SubscriptionPlans.FREE
    Scaffold(
        backgroundColor = AppColors.background,
        modifier = Modifier
            .fillMaxWidth()
            .padding(),
        topBar = {
            Toolbar("Range") {
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

                    var modifier = Modifier.blur(0.dp)
                    if (isFree) {
                        modifier = Modifier.blur(12.dp)
                    }
                    Box(modifier.align(Alignment.Center)) {
                        Text(
                            " ${range.value} km ",
                            color = Color.White,
                            modifier = Modifier.align(Alignment.Center),
                            fontSize = 42.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }


            }
            if (isFree)
                Box(modifier = Modifier.align(Alignment.BottomCenter)) {
                    UpgradeBox(navController, "Upgrade to set your precise range")
                }
        }


    }
}