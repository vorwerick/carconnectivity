package com.ixperta.android.connectivity.presentation.subscriptions

import androidx.lifecycle.ViewModel
import com.ixperta.android.connectivity.application.car.GetProductPlans
import com.ixperta.android.connectivity.domain.catalog.enity.PlanEntity
import com.ixperta.android.connectivity.presentation.car.SubscriptionPlans
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.java.KoinJavaComponent.get



class SubscriptionPlanViewModel : ViewModel() {
    private val _plans =
        MutableStateFlow<List<PlanEntity>>(listOf<PlanEntity>())

    val plans: StateFlow<List<PlanEntity>> = _plans

    suspend fun fetchPlans(){
        val getProductPlans: GetProductPlans = get(GetProductPlans::class.java)
        val result = getProductPlans.execute()

        _plans.value = result
    }



}