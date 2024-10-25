package com.ixperta.android.connectivity.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ixperta.android.connectivity.ui.nav.Route
import com.ixperta.android.connectivity.ui.styles.AppColors

@Composable
fun UpgradeBox(navHostController: NavHostController, description: String) {
    Box(modifier = Modifier.background(AppColors.carItemBackground)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 12.dp)
        ) {
            StatusBadge("Pro feature", AppColors.skodaGreenColor, AppColors.carItemBackground)
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Upgrade your plan",
                fontWeight = FontWeight(600),
                fontSize = 20.sp,
                color = Color.White

            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = description,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                color = AppColors.carItemTitleColor

            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally).padding(vertical = 6.dp)
                    .fillMaxWidth()
            ) {
                GreenButton({
                    navHostController.navigate(Route.SubscriptionPlans.route)
                }, "Upgrade")
            }

        }
    }


}