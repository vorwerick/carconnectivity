package com.ixperta.android.connectivity.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ixperta.android.connectivity.presentation.auth.AuthViewModel
import com.ixperta.android.connectivity.presentation.car.CarViewModel
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlanViewModel
import com.ixperta.android.connectivity.ui.components.BottomNavBar
import com.ixperta.android.connectivity.ui.nav.BottomNavigationRoute
import com.ixperta.android.connectivity.ui.screens.home.CarScreen
import com.ixperta.android.connectivity.ui.screens.home.InspectScreen
import com.ixperta.android.connectivity.ui.screens.home.MapScreen
import com.ixperta.android.connectivity.ui.screens.home.ProfileScreen

@Composable
fun HomeScreen(
    mainNavController: NavHostController,
    subscriptionPlanViewModel: SubscriptionPlanViewModel,
    authViewModel: AuthViewModel
) {
    val bottomNavController = rememberNavController()
    val carViewModel = viewModel { CarViewModel() }

    Scaffold(
        bottomBar = {
            BottomNavBar(bottomNavController)
        }
    ) { innerPadding ->
        NavHost(
            bottomNavController,
            startDestination = BottomNavigationRoute.Car.route,
            Modifier.padding(innerPadding)
        ) {
            composable(BottomNavigationRoute.Car.route) {
                CarScreen(
                    carViewModel,
                    mainNavController, subscriptionPlanViewModel
                )
            }
            composable(BottomNavigationRoute.Map.route) {
                MapScreen(
                    mainNavController,
                    subscriptionPlanViewModel
                )
            }
            composable(BottomNavigationRoute.Inspect.route) {
                InspectScreen(
                    mainNavController,
                    subscriptionPlanViewModel
                )
            }
            composable(BottomNavigationRoute.Profile.route) {
                ProfileScreen(
                    mainNavController,
                    carViewModel,
                    subscriptionPlanViewModel,
                    authViewModel
                )
            }
        }
    }
}