package com.ixperta.android.connectivity.ui.components

import androidx.compose.foundation.background
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
import androidx.compose.material.Colors
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
fun PackageCardTitles() {
    val scope = rememberCoroutineScope()
    Column(
        Modifier
            .width(300.dp)
            .fillMaxHeight().background(Color.Transparent)
    ) {
        Spacer(Modifier.height(32.dp))

        Spacer(Modifier.height(6.dp))
        Text("", color = AppColors.carItemTitleColor, fontSize = 22.sp)
        Spacer(Modifier.height(16.dp))
        Text(
            "",
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(16.dp))
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 16.dp, end = 16.dp, bottom = 48.dp),
        ) {
            Text(
                "Remote control",
                color = AppColors.textWhiteColor,
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(18.dp)
            )
            Text(
                "In-car live Gas, Parking",
                color = AppColors.textWhiteColor,
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(18.dp)
            )
            Text(
                "In-car live Voice-Control",
                color = AppColors.textWhiteColor,
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(18.dp)
            )
            Text(
                "In-car data with hotspot",
                color = AppColors.textWhiteColor,
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(18.dp)
            )

        }

    }


}