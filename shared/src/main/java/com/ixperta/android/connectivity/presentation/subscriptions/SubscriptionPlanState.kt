package com.ixperta.android.connectivity.presentation.subscriptions


sealed class SubscriptionPlanState {

    data object NotInitialized : SubscriptionPlanState()
    data object Free : SubscriptionPlanState()
    data object Basic : SubscriptionPlanState()
    data object Premium : SubscriptionPlanState()
}

