package com.ixperta.android.connectivity.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SubscriptionCard(
    price: String,
    badge: @Composable () -> Unit,
    notes: List<String>,
    action: () -> Unit
) {
    Card(backgroundColor = Color.DarkGray, modifier = Modifier.padding(all = 8.dp)) {
        Column(Modifier.fillMaxWidth()) {
            badge()
            Text(price, fontSize = 42.sp, color = Color.White)
            notes.map {
                Row {
                    Icon(Icons.AutoMirrored.Outlined.KeyboardArrowRight, "li")
                    Box(modifier = Modifier.width(16.dp))
                    Text(it, color = Color.Gray)
                }
            }
            OutlinedButton(
                onClick = action,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 25.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = "Upgrade",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }
        }

    }


}