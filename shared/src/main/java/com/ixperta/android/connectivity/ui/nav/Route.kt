package com.ixperta.android.connectivity.ui.nav


sealed class Route(val route: String, val label: String) {
    data object Home : Route("home", "Home")
    data object SubscriptionPlans : Route("subscriptions", "Subscriptions")
    data object VehicleStatus : Route("vehicle_status", "Vehicle status")
    data object ClimateControl : Route("climate_control", "Climate control")
    data object Range : Route("range", "Range")
    data object Navigation : Route("navigation", "Navigation")

}
