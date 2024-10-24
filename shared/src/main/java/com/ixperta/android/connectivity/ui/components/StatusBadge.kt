package com.ixperta.android.connectivity.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StatusBadge( label: String, color: Color){
    Box(modifier = Modifier.padding(all = 4.dp).background(color = color)) {
        Text(label, color = Color.Black, modifier = Modifier.padding(all = 4.dp), fontSize = 12.sp, fontWeight = FontWeight(700))
    }
}