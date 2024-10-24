package com.ixperta.android.connectivity.ui.components.car

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ixperta.android.connectivity.ui.components.StatusBadge
import com.ixperta.android.connectivity.ui.nav.Route
import com.ixperta.android.connectivity.ui.styles.AppColors

@Composable
fun InspectCarItem(
    title: String,
    description: String,
    badge: String?,
    icon: ImageVector?,
    isFree: Boolean,
    navController: NavHostController,
) {
    Card(
        backgroundColor = AppColors.carItemBackground,
        modifier = Modifier.padding(start = 12.dp, bottom = 10.dp, end = 12.dp)
    ) {
        Column(Modifier.fillMaxWidth()) {
            Row() {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        title,
                        fontSize = 22.sp,
                        fontWeight = FontWeight(600),
                        color = Color.White,
                        modifier = Modifier.padding(start = 24.dp, top = 16.dp)
                    )

                    var modifier = Modifier.blur(0.dp)
                    if(isFree){
                        modifier = Modifier.blur(8.dp)
                    }
                    Box(modifier){
                        Text(
                            description,
                            color = AppColors.carItemTitleColor,
                            modifier = Modifier.padding(start = 24.dp, top = 8.dp, bottom = 16.dp)
                        )
                    }

                }
                badge?.also {
                    Row(modifier = Modifier.align(Alignment.CenterVertically)) {
                        StatusBadge(it, AppColors.skodaGreenColor, AppColors.carItemBackground)
                    }
                }

                Row(modifier = Modifier.align(Alignment.CenterVertically)) {
                    if (isFree)
                        icon?.also {
                            IconButton(
                                onClick = {
                                    navController.navigate(Route.SubscriptionPlans.route)
                                },
                                enabled = true
                            ) {
                                Icon(
                                    Icons.AutoMirrored.Default.KeyboardArrowRight,
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