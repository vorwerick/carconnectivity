package com.ixperta.android.connectivity

import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.tasks.Task
import com.google.android.gms.wallet.PaymentData
import com.ixperta.android.connectivity.configuration.app.AppConfig
import com.ixperta.android.connectivity.domain.user.entity.UserEntity
import com.ixperta.android.connectivity.infrastructure.user.FakeUserRepository
import com.ixperta.android.connectivity.presentation.auth.AuthViewModel
import com.ixperta.android.connectivity.presentation.car.CarViewModel
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlanViewModel
import com.ixperta.android.connectivity.ui.nav.Route
import com.ixperta.android.connectivity.ui.screens.ClimateControlScreen
import com.ixperta.android.connectivity.ui.screens.HomeScreen
import com.ixperta.android.connectivity.ui.screens.NavigationScreen
import com.ixperta.android.connectivity.ui.screens.PackagesScreen
import com.ixperta.android.connectivity.ui.screens.RangeScreen
import com.ixperta.android.connectivity.ui.screens.SubscriptionScreen
import com.ixperta.android.connectivity.ui.screens.VehicleStatusScreen
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.get


@Composable
fun ConnectivityAppAutomotive(appConfig: AppConfig) {
    val carViewModel = viewModel { CarViewModel() }
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect("fetch") {
        coroutineScope.launch {
            val fakeUser: FakeUserRepository = get(FakeUserRepository::class.java)
            carViewModel.fetchData(fakeUser.getCurrentUser())
        }
    }

    val navController = rememberNavController()
    val subscriptionPlanViewModel = viewModel { SubscriptionPlanViewModel() }


    Scaffold(contentWindowInsets = WindowInsets.navigationBars) { padding ->
        NavHost(
            navController = navController,
            startDestination = Route.Navigation.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Route.Navigation.route) {
                NavigationScreen(
                    navController,
                    subscriptionPlanViewModel,
                    carViewModel
                )
            }
            composable(Route.Package.route) {
                PackagesScreen(
                    navController,
                    carViewModel, appConfig
                )
            }

        }
    }


}

