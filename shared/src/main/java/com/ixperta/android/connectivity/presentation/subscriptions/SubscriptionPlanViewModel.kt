package com.ixperta.android.connectivity.presentation.subscriptions

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

enum class SubscriptionPlans{
    FREE, ADVANCED, PREMIUM
}

class SubscriptionPlanViewModel : ViewModel() {
    private val _subscriptionPlan =
        MutableStateFlow<SubscriptionPlans>(SubscriptionPlans.FREE)

    val subscriptionPlan: StateFlow<SubscriptionPlans> = _subscriptionPlan

    fun fetchCurrentPlan(){
        //get paid subscription
        _subscriptionPlan.value = SubscriptionPlans.PREMIUM
    }


}