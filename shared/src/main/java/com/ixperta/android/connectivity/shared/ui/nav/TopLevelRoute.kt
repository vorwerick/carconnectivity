package com.ixperta.android.connectivity.shared.ui.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class TopLevelRoute(val route: String, val icon: ImageVector, val label: String) {
    data object Car : TopLevelRoute("car", Icons.Default.ShoppingCart, "Car")
    data object Map : TopLevelRoute("map", Icons.Default.Place, "Map")
    data object Inspect : TopLevelRoute("inspect", Icons.Default.Search, "Inspect")
    data object Profile : TopLevelRoute("profile", Icons.Default.Person, "Profile")

    companion object {
        val values = listOf(Car, Map, Inspect, Profile)
    }
}

