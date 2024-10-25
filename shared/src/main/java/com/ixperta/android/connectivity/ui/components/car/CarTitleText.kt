package com.ixperta.android.connectivity.ui.components.car

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ixperta.android.connectivity.presentation.car.SubscriptionPlans
import com.ixperta.android.connectivity.ui.styles.AppColors
import com.ixperta.android.connectivity.ui.utils.BadgeByPlan

@Composable
fun CarTitleText(title: String, subscriptionPlan: SubscriptionPlans) {
    Column( modifier = Modifier.padding(start = 24.dp, top = 32.dp, bottom = 8.dp),) {
        Text(
            title,

            color = AppColors.textWhiteColor,
            fontSize = 40.sp,
            fontWeight = FontWeight(700)
        )
        Spacer(Modifier.height(8.dp))
        BadgeByPlan(subscriptionPlan)
    }

}