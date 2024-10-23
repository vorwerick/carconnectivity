package com.ixperta.android.connectivity.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ixperta.android.connectivity.ui.nav.BottomNavigationRoute
import com.ixperta.android.connectivity.ui.styles.AppColors

@Composable
fun BottomNavBar(navController: NavController) {
    BottomNavigation(backgroundColor = AppColors.background) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        BottomNavigationRoute.values.forEach { item ->
            BottomNavigationItem(
                selectedContentColor = AppColors.skodaGreenColor,
                unselectedContentColor = AppColors.textWhiteColor,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {

                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                },
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(item.label) }
            )
        }
    }
}