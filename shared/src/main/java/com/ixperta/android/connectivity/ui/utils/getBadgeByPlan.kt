package com.ixperta.android.connectivity.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.ixperta.android.connectivity.presentation.car.SubscriptionPlans
import com.ixperta.android.connectivity.ui.components.StatusBadge
import com.ixperta.android.connectivity.ui.styles.AppColors

@Composable
fun BadgeByPlan(plan: SubscriptionPlans) {
    if (plan == SubscriptionPlans.free) {
        return StatusBadge("FREE", AppColors.blueBadgeColor, Color.White)
    }
    if (plan == SubscriptionPlans.basic) {
        return StatusBadge("BASIC", Color.Green, Color.White)
    }
    if (plan == SubscriptionPlans.advanced) {
        return StatusBadge("ADVANCED", AppColors.magentaBadgeColor, Color.White)
    }
    if (plan == SubscriptionPlans.premium) {
        return StatusBadge("PREMIUM", AppColors.orangeBadgeColor, Color.White)
    }
}