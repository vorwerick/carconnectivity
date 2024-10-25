package com.ixperta.android.connectivity.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
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
import com.ixperta.android.connectivity.ui.components.PackageCardTitles
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
    Scaffold(

        modifier = Modifier
            .fillMaxWidth()
            .padding()
    ) {
        Box(
            Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            AppColors.automotiveBackground1,
                            AppColors.automotiveBackground2
                        )
                    )
                )
                .fillMaxWidth()
        ) {
            Column {
                Box(
                    Modifier
                        .padding(top = 112.dp)
                        .fillMaxWidth()
                ) {


                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(Modifier.padding(24.dp)) {
                            IconButton({
                                navController.popBackStack()
                            }, modifier = Modifier.background(AppColors.carItemBackground)) {
                                Icon(
                                    Icons.Default.Search,
                                    "",
                                    tint = AppColors.textWhiteColor
                                )
                            }
                        }
                        Box(
                            Modifier
                                .background(AppColors.tabBackground)
                                .padding(all = 24.dp)
                        ) {
                            Text(
                                "Connect plans",
                                color = AppColors.skodaGreenColor,
                                fontSize = 24.sp
                            )
                        }

                        Box(Modifier.padding(24.dp)) {
                            GreenButton(
                                {

                                    scope.launch {
                                        checkoutViewModel.requestPayment(
                                            100.toLong(),
                                            appConfig.paymentDataLauncher
                                        )
                                        carViewModel.boughtPlan(
                                            selectedPlan.value,
                                            fakeUser.getCurrentUser().email
                                        )
                                        navController.popBackStack()
                                    }
                                },
                                "Pay",
                                maxWidth = false,
                                enabled = selectedPlan.value != SubscriptionPlans.free && selectedPlan.value != plan.value
                            )
                        }

                    }
                }
                Row(
                    Modifier.padding(top = 16.dp, start = 64.dp, end = 16.dp),
                    horizontalArrangement = Arrangement.End
                ) {

                    PackageCardTitles()
                    PackageCard(
                        59,
                        "CZK",
                        {
                            Text(
                                "BASIC",
                                color = Color.White,
                                fontSize = 24.sp
                            )
                        },
                        "100MB in EU",
                        navController,
                        SubscriptionPlans.basic,
                        plan.value,
                        selectedPlan.value,

                        appConfig,
                        carViewModel,
                        fakeUser.getCurrentUser().email,
                        {
                            selectedPlan.value = SubscriptionPlans.basic
                        }
                    )
                    PackageCard(
                        129,
                        "CZK",
                        {
                            Text(
                                "ADVANCED",
                                color = Color.White,
                                fontSize = 24.sp
                            )
                        },
                        "500MB in EU",
                        navController,
                        SubscriptionPlans.advanced,
                        plan.value,
                        selectedPlan.value,

                        appConfig,
                        carViewModel,
                        fakeUser.getCurrentUser().email,
                        {
                            selectedPlan.value = SubscriptionPlans.advanced
                        }
                    )
                    PackageCard(
                        259,
                        "CZK",
                        {
                            Text(
                                "PREMIUM",
                                color = Color.White,
                                fontSize = 24.sp
                            )
                        },
                        "2GB in EU",
                        navController,
                        SubscriptionPlans.premium,
                        plan.value,
                        selectedPlan.value,

                        appConfig,
                        carViewModel,
                        fakeUser.getCurrentUser().email,
                        {
                            selectedPlan.value = SubscriptionPlans.premium
                        }
                    )


                }
            }

        }
    }


}

