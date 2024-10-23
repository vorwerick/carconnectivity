package com.ixperta.android.connectivity.ui.nav



sealed class Route(val route: String, val label: String) {
    data object Home : Route("home", "Home")
    data object SubscriptionPlans : Route("subscriptions", "Subscriptions")


    companion object {
        val values = listOf(Home,SubscriptionPlans)
    }
}
