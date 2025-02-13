package com.ixperta.android.connectivity

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ixperta.android.connectivity.configuration.app.AppConfig
import com.ixperta.android.connectivity.domain.user.entity.UserEntity
import com.ixperta.android.connectivity.presentation.auth.AuthState
import com.ixperta.android.connectivity.presentation.auth.AuthViewModel
import com.ixperta.android.connectivity.presentation.car.CarViewModel
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlanViewModel
import com.ixperta.android.connectivity.ui.nav.Route
import com.ixperta.android.connectivity.ui.screens.ClimateControlScreen
import com.ixperta.android.connectivity.ui.screens.HomeScreen
import com.ixperta.android.connectivity.ui.screens.LoginScreen
import com.ixperta.android.connectivity.ui.screens.RangeScreen
import com.ixperta.android.connectivity.ui.screens.SplashScreen
import com.ixperta.android.connectivity.ui.screens.SubscriptionScreen
import com.ixperta.android.connectivity.ui.screens.VehicleStatusScreen
import kotlinx.coroutines.launch


@Composable
fun Main(authViewModel: AuthViewModel, appConfig: AppConfig) {

    val authState by authViewModel.authState.collectAsState()
    val subscriptionPlanViewModel = viewModel { SubscriptionPlanViewModel() }

    val mainNavController = rememberNavController()
    when (authState) {
        AuthState.Logged -> AuthenticatedScreen(
            mainNavController, subscriptionPlanViewModel, authViewModel, appConfig
        )

        AuthState.Unlogged -> LoginScreen(authViewModel)
        else -> SplashScreen()
    }
}

@Composable
fun AuthenticatedScreen(
    navController: NavHostController,
    subscriptionPlanViewModel: SubscriptionPlanViewModel,
    authViewModel: AuthViewModel,
    appConfig: AppConfig
) {
    val scope = rememberCoroutineScope()
    val carViewModel = viewModel { CarViewModel() }
    LaunchedEffect("launch_model") {
        scope.launch {
            carViewModel.fetchData(UserEntity(authViewModel.currentUser.value!!))
        }
    }
    Scaffold(contentWindowInsets = WindowInsets.navigationBars) { padding ->
        NavHost(
            navController = navController,
            startDestination = Route.Home.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Route.SubscriptionPlans.route) {
                SubscriptionScreen(
                    navController, carViewModel, authViewModel, appConfig
                )
            }
            composable(Route.Home.route) {
                HomeScreen(
                    navController, subscriptionPlanViewModel, carViewModel, authViewModel
                )
            }
            composable(Route.VehicleStatus.route) {
                VehicleStatusScreen(
                    navController,
                    subscriptionPlanViewModel, carViewModel, authViewModel
                )
            }
            composable(Route.ClimateControl.route) {
                ClimateControlScreen(
                    navController, subscriptionPlanViewModel, carViewModel
                )
            }
            composable(Route.Range.route) {
                RangeScreen(
                    navController, subscriptionPlanViewModel, carViewModel
                )
            }
        }
    }

}