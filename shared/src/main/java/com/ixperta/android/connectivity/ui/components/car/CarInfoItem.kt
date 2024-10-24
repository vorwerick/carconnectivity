package com.ixperta.android.connectivity.ui.components.car

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlans
import com.ixperta.android.connectivity.ui.components.StatusBadge
import com.ixperta.android.connectivity.ui.styles.AppColors


@Composable
fun CarInfoItem(
    title: String,
    subscriptionPlan: SubscriptionPlans,
    description: @Composable () -> Unit,
    badge: String?,
    action: (() -> Unit)?
) {
    Card(backgroundColor = AppColors.carItemBackground, modifier = Modifier.padding(bottom = 10.dp, start = 12.dp, end = 12.dp)) {
        Column(
            Modifier
                .fillMaxWidth()

        ) {
            Row() {
                Column(modifier = Modifier.weight(1f).align(Alignment.CenterVertically)) {
                    Text(
                        title,
                        color = AppColors.carItemTitleColor,
                        modifier = Modifier.padding(start = 24.dp, top = 16.dp,),
                        fontWeight = FontWeight(500)
                    )
                    description()
                }

                if (subscriptionPlan == SubscriptionPlans.FREE) {
                    badge?.also {
                        Row(modifier = Modifier.align(Alignment.CenterVertically)) {
                            StatusBadge(it, AppColors.skodaGreenColor)
                        }
                    }
                }

                Row(modifier = Modifier.align(Alignment.CenterVertically)) {
                    action?.also {
                        IconButton(
                            onClick = action,
                            enabled = true
                        ) {
                            Icon(
                                Icons.Default.KeyboardArrowRight,
                                "",
                                tint = Color.White,
                                modifier = Modifier.size(42.dp)
                            )
                        }
                    }

                }
            }
        }
    }
}