package com.ixperta.android.connectivity.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.ixperta.android.connectivity.configuration.app.AppConfig
import com.ixperta.android.connectivity.presentation.car.CarViewModel
import com.ixperta.android.connectivity.presentation.car.SubscriptionPlans
import com.ixperta.android.connectivity.presentation.payment.CheckoutViewModel
import com.ixperta.android.connectivity.ui.styles.AppColors
import kotlinx.coroutines.launch

@Composable
fun PackageCard(
    priceCents: Int,
    currency: String,
    badge: @Composable () -> Unit,
    notes: String,
    navHostController: NavHostController,
    subscriptionPlan: SubscriptionPlans,
    currentSubscriptionPlan: SubscriptionPlans,
    appConfig: AppConfig,
    carViewModel: CarViewModel,
    user: String,
    checkoutViewModel: CheckoutViewModel = viewModel(),

    ) {
    val scope = rememberCoroutineScope()
    Card(
        backgroundColor = AppColors.carItemBackground,
        modifier = Modifier.padding(top = 16.dp, end = 16.dp, bottom = 48.dp),
        shape = RoundedCornerShape(10),
    ) {
        Column(
            Modifier
                .width(300.dp)
                .fillMaxHeight()
                .padding(16.dp)
        ) {
            badge()

            Spacer(Modifier.height(6.dp))
            Text(notes, color = AppColors.carItemTitleColor, fontSize = 22.sp)
            Spacer(Modifier.height(16.dp))
            Text(
                "${priceCents.toString()} ${currency}/month",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(16.dp))
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                Icon(Icons.Default.Clear, "", tint = Color.White)
                Icon(Icons.Default.Clear, "", tint = Color.White)
                Icon(Icons.Default.Clear, "", tint = Color.White)
                Icon(Icons.Default.Clear, "", tint = Color.White)

            }

        }

    }


}