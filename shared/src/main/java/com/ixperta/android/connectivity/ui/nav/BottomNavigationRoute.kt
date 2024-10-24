package com.ixperta.android.connectivity.ui.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationRoute(val route: String, val icon: ImageVector, val label: String) {
    data object Car : BottomNavigationRoute("car", Icons.Default.Favorite, "Car")
    data object Map : BottomNavigationRoute("map", Icons.Default.Place, "Map")
    data object Inspect : BottomNavigationRoute("inspect", Icons.Default.Search, "Inspect")
    data object Profile : BottomNavigationRoute("profile", Icons.Default.Person, "Profile")

    companion object {
        val values = listOf(Car, Map, Inspect, Profile)
    }
}

