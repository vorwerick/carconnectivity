package com.ixperta.android.connectivity.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.ixperta.android.connectivity.application.car.SetBoughtPlan
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
    boughtPlan: SubscriptionPlans,
    currentSubscriptionPlan: SubscriptionPlans,
    appConfig: AppConfig,
    carViewModel: CarViewModel,
    user: String,
    onClick: () -> Unit,
    checkoutViewModel: CheckoutViewModel = viewModel(),

    ) {
    val selected = currentSubscriptionPlan == subscriptionPlan
    val scope = rememberCoroutineScope()
    var borderWidth = 0.dp
    var borderColor = Color.Transparent
    if(subscriptionPlan == boughtPlan){
        borderWidth = 2.dp
        borderColor = AppColors.textWhiteColor
    }
    if (selected) {
        borderWidth = 2.dp
        borderColor = AppColors.skodaGreenColor
    }
    Card(
        backgroundColor = AppColors.automotiveCardBackground,
        modifier = Modifier
            .padding(top = 16.dp, end = 16.dp, bottom = 48.dp)
            .border(width = borderWidth, color = borderColor)
            .clickable {
                onClick.invoke()
            },
        shape = RoundedCornerShape(10),
    ) {
        Column(
            Modifier
                .width(300.dp)
                .fillMaxHeight()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            badge()

            Spacer(Modifier.height(6.dp))
            if(boughtPlan == subscriptionPlan){
                Text("your current plan", color = AppColors.textWhiteColor, fontSize = 22.sp)

            } else {
                Text(notes, color = AppColors.carItemTitleColor, fontSize = 22.sp)

            }
            Spacer(Modifier.height(16.dp))
            Text(
                "${priceCents.toString()} ${currency}/month",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(20.dp))
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxHeight()
            ) {
                Icon(
                    Icons.Default.Clear,
                    "",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(28.dp)
                )
                Icon(
                    Icons.Default.Clear,
                    "",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(28.dp)
                )
                Icon(
                    Icons.Default.Clear,
                    "",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(28.dp)
                )
                Icon(
                    Icons.Default.Clear,
                    "",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(28.dp)
                )

            }

        }

    }


}