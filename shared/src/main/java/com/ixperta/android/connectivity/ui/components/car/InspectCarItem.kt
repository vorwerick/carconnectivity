package com.ixperta.android.connectivity.ui.components.car

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
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ixperta.android.connectivity.ui.components.StatusBadge
import com.ixperta.android.connectivity.ui.styles.AppColors

@Composable
fun InspectCarItem(title: String, description: String, badge: String?, icon: ImageVector, action: () -> Unit) {
    Card(backgroundColor = Color.DarkGray, modifier = Modifier.padding(all = 8.dp)) {
        Column(Modifier.fillMaxWidth()) {
            Row() {
                Column(modifier = Modifier.weight(1f)) {
                    Text(title, fontSize = 24.sp, color = Color.White, modifier = Modifier.padding(start = 24.dp, top = 8.dp))

                    Text(description, color = Color.White,modifier = Modifier.padding(start = 24.dp, top = 8.dp, bottom = 16.dp,))

                }
                badge?.also {
                    Row(modifier = Modifier.align(Alignment.CenterVertically)) {
                        StatusBadge(it, AppColors.blueBadgeColor)
                    }
                }

                Row(modifier = Modifier.align(Alignment.CenterVertically)) {
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