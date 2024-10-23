package com.ixperta.android.connectivity.presentation.subscriptions

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SubscriptionPlanViewModel : ViewModel() {
    private val _subscriptionPlan =
        MutableStateFlow<SubscriptionPlanState>(SubscriptionPlanState.Free)

    val subscriptionPlan: StateFlow<SubscriptionPlanState> = _subscriptionPlan

    fun fetchCurrentPlan(){
        //get paid subscription
        _subscriptionPlan.value = SubscriptionPlanState.Free
    }


}