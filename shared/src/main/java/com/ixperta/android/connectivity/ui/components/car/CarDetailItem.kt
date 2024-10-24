package com.ixperta.android.connectivity.ui.components.car

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ixperta.android.connectivity.ui.components.StatusBadge
import com.ixperta.android.connectivity.ui.styles.AppColors

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CarDetailItem(title: String, subtitle: String, action: (() -> Unit)? = null, badge: String? = null) {
    Column {
        ListItem(
            secondaryText = {
                Text(subtitle, color = AppColors.carItemTitleColor)
            },
            trailing = {
               Column(Modifier.align(Alignment.CenterHorizontally)) {
                   Row() {
                       badge?.also {
                           StatusBadge(it,AppColors.skodaGreenColor, AppColors.carItemBackground)

                       }
                       action?.also {
                           IconButton(onClick = action) {
                               Icon(
                                   Icons.AutoMirrored.Default.KeyboardArrowRight,
                                   "",
                                   modifier = Modifier.padding(),
                                   Color.White
                               )
                           }

                       }
                   }
               }


            }) { Text(title, color = Color.White) }
        Divider(color = AppColors.carItemBackground)
    }
}