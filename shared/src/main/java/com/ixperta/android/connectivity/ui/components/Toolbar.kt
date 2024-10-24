package com.ixperta.android.connectivity.ui.components

import android.widget.Toolbar
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.ixperta.android.connectivity.ui.styles.AppColors

@Composable
fun Toolbar(title: String, navigationClick: (() -> Unit)?) {
    TopAppBar(backgroundColor = AppColors.background, title = {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(title, fontWeight = FontWeight(600), color = Color.White)
        }
    }, modifier = Modifier.padding(), navigationIcon = {
        navigationClick?.also {
            IconButton(onClick = {
                it()
            },) {
                Icon(tint = Color.White,
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Localized description"
                )
            }
        }

    })
}