package com.ixperta.android.connectivity.shared

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ixperta.android.connectivity.shared.ui.components.BottomNavBar
import com.ixperta.android.connectivity.shared.ui.nav.TopLevelRoute
import com.ixperta.android.connectivity.shared.ui.screens.CarScreen
import com.ixperta.android.connectivity.shared.ui.screens.MapScreen
import com.ixperta.android.connectivity.shared.ui.screens.ProfileScreen

@Composable
fun ConnectivityApp() {
    val coroutineScope = rememberCoroutineScope()

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = TopLevelRoute.Car.route,
            Modifier.padding(innerPadding)
        ) {
            composable(TopLevelRoute.Car.route) { CarScreen() }
            composable(TopLevelRoute.Map.route) { MapScreen() }
            composable(TopLevelRoute.Inspect.route) { ProfileScreen() }
            composable(TopLevelRoute.Profile.route) { ProfileScreen() }
        }
    }
}