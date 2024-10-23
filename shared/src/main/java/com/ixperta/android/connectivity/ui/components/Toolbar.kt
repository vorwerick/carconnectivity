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
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Toolbar(title: String, navigationClick: (() -> Unit)?) {
    TopAppBar(title = {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(title)
        }
    }, modifier = Modifier.padding(), navigationIcon = {
        navigationClick?.also {
            IconButton(onClick = {
                it()
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Localized description"
                )
            }
        }

    })
}