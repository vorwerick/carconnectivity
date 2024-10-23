package com.ixperta.android.connectivity.ui.components.car

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ixperta.android.connectivity.ui.styles.AppColors

@Composable
fun CarTitleText(title: String) {
    Text(
        title,
        modifier = Modifier.padding(start = 24.dp, top = 32.dp, bottom = 32.dp),
        color = AppColors.textWhiteColor,
        fontSize = 40.sp,
        fontWeight = FontWeight(700)
    )

}