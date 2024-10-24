package com.ixperta.android.connectivity.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.ixperta.android.connectivity.configuration.app.AppConfig
import com.ixperta.android.connectivity.infrastructure.user.FakeUserRepository
import com.ixperta.android.connectivity.presentation.auth.AuthViewModel
import com.ixperta.android.connectivity.presentation.car.CarViewModel
import com.ixperta.android.connectivity.presentation.car.SubscriptionPlans
import com.ixperta.android.connectivity.presentation.payment.CheckoutViewModel
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlanViewModel
import com.ixperta.android.connectivity.ui.components.GreenButton
import com.ixperta.android.connectivity.ui.components.PackageCard
import com.ixperta.android.connectivity.ui.components.StatusBadge
import com.ixperta.android.connectivity.ui.components.SubscriptionCard
import com.ixperta.android.connectivity.ui.components.Toolbar
import com.ixperta.android.connectivity.ui.styles.AppColors
import com.ixperta.android.connectivity.ui.utils.BadgeByPlan
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.get

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PackagesScreen(
    navController: NavHostController,
    carViewModel: CarViewModel,
    appConfig: AppConfig,
    checkoutViewModel: CheckoutViewModel = viewModel()
) {
    val scope = rememberCoroutineScope()
    val fakeUser: FakeUserRepository = get(FakeUserRepository::class.java)
    val selectedPlan =
        remember<MutableState<SubscriptionPlans>> { mutableStateOf(SubscriptionPlans.free) }
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
    ) {

        Column {
            Row(
                Modifier
                    .height(120.dp)
                    .background(Color.Red)
            ) {

            }
            Row(
            ) {

                var index = 0
                plans.value.filter { it.displayName != "basic" }.map {

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
                    PackageCard(
                        it.priceMonthly,
                        it.priceUnit,
                        {
                            Text(
                                currentPlan.name.uppercase(),
                                color = Color.White,
                                fontSize = 24.sp
                            )
                        },
                        it.subtitle,
                        navController,
                        currentPlan,
                        carViewModel.plan.value,
                        appConfig,
                        carViewModel,
                        fakeUser.getCurrentUser().email,
                    )
                    index++
                }

                GreenButton({

                    scope.launch {
                        checkoutViewModel.requestPayment(
                            100.toLong(),
                            appConfig.paymentDataLauncher
                        )
                        carViewModel.boughtPlan(selectedPlan.value, fakeUser.getCurrentUser().email)
                        navController.popBackStack()
                    }
                }, "Pay")


            }
        }
    }


}

