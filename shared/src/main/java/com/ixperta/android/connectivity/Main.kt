package com.ixperta.android.connectivity

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ixperta.android.connectivity.presentation.auth.AuthState
import com.ixperta.android.connectivity.presentation.auth.AuthViewModel
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlanViewModel
import com.ixperta.android.connectivity.ui.nav.Route
import com.ixperta.android.connectivity.ui.screens.HomeScreen
import com.ixperta.android.connectivity.ui.screens.LoginScreen
import com.ixperta.android.connectivity.ui.screens.SplashScreen
import com.ixperta.android.connectivity.ui.screens.SubscriptionScreen


@Composable
fun Main(authViewModel: AuthViewModel, requestPayment: () -> Unit) {

    val authState by authViewModel.authState.collectAsState()
    val subscriptionPlanViewModel = viewModel { SubscriptionPlanViewModel() }

    val mainNavController = rememberNavController()
    when (authState) {
        AuthState.Logged -> AuthenticatedScreen(mainNavController, requestPayment, subscriptionPlanViewModel)
        AuthState.Unlogged -> LoginScreen(authViewModel)
        else -> SplashScreen()
    }
}

@Composable
fun AuthenticatedScreen(
    navController: NavHostController,
    requestPayment: () -> Unit,
    subscriptionPlanViewModel: SubscriptionPlanViewModel
) {
    NavHost(navController = navController, startDestination = Route.Home.route) {
        composable(Route.SubscriptionPlans.route) { SubscriptionScreen(navController, requestPayment) }
        composable(Route.Home.route) { HomeScreen(navController, subscriptionPlanViewModel) }
    }
}