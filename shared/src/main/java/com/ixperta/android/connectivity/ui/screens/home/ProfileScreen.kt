package com.ixperta.android.connectivity.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlanViewModel

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
    navController: NavHostController,
    subscriptionPlanViewModel: SubscriptionPlanViewModel
) {
    Scaffold(backgroundColor = Color.Black, topBar = {}) {

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Box(
                Modifier
                    .background(Color.Black)
                    .fillMaxWidth()
            ) {
                Text(
                    "Car information",
                    modifier = Modifier.padding(start = 24.dp, top = 32.dp, bottom = 32.dp),
                    color = Color.White,
                    fontSize = 32.sp,
                )

            }
            Image(
                painter = rememberAsyncImagePainter("https://performance.ford.com/content/fordracing/home/performance-vehicles/_jcr_content/par/fr_external_link_com_1/image.img.jpg/1682003432572.jpg"),
                contentDescription = null,

                modifier = Modifier.height(128.dp)

            )
            ListItem(
                secondaryText = {
                    Text("Popis", color = Color.White)
                },
                trailing = {
                    Icon(
                        Icons.AutoMirrored.Default.KeyboardArrowRight,
                        "",
                        modifier = Modifier.padding(),
                        Color.White
                    )
                }) { Text("Ahoj", color = Color.White) }
            Divider()
            ListItem(
                secondaryText = {
                    Text("Popis", color = Color.White)
                },
                trailing = {
                    Icon(
                        Icons.AutoMirrored.Default.KeyboardArrowRight,
                        "",
                        modifier = Modifier.padding(),
                        Color.White
                    )
                }) { Text("Ahoj", color = Color.White) }
            Divider()
            ListItem(
                secondaryText = {
                    Text("Popis", color = Color.White)
                },
                trailing = {
                    Icon(
                        Icons.AutoMirrored.Default.KeyboardArrowRight,
                        "",
                        modifier = Modifier.padding(),
                        Color.White
                    )
                }) { Text("Ahoj", color = Color.White) }
            Divider()
            ListItem(
                secondaryText = {
                    Text("Popis", color = Color.White)
                },
                trailing = {
                    Icon(
                        Icons.AutoMirrored.Default.KeyboardArrowRight,
                        "",
                        modifier = Modifier.padding(),
                        Color.White
                    )
                }) { Text("Ahoj", color = Color.White) }
            Divider()
            ListItem(
                secondaryText = {
                    Text("Popis", color = Color.White)
                },
                trailing = {
                    Icon(
                        Icons.AutoMirrored.Default.KeyboardArrowRight,
                        "",
                        modifier = Modifier.padding(),
                        Color.White
                    )
                }) { Text("Ahoj", color = Color.White) }
            Divider()
            ListItem(
                secondaryText = {
                    Text("Popis", color = Color.White)
                },
                trailing = {
                    Icon(
                        Icons.AutoMirrored.Default.KeyboardArrowRight,
                        "",
                        modifier = Modifier.padding(),
                        Color.White
                    )
                }) { Text("Ahoj", color = Color.White) }
            Divider()
            ListItem(
                secondaryText = {
                    Text("Popis", color = Color.White)
                },
                trailing = {
                    Icon(
                        Icons.AutoMirrored.Default.KeyboardArrowRight,
                        "",
                        modifier = Modifier.padding(),
                        Color.White
                    )
                }) { Text("Ahoj", color = Color.White) }
            Divider()
            ListItem(
                secondaryText = {
                    Text("Popis", color = Color.White)
                },
                trailing = {
                    Icon(
                        Icons.AutoMirrored.Default.KeyboardArrowRight,
                        "",
                        modifier = Modifier.padding(),
                        Color.White
                    )
                }) { Text("Ahoj", color = Color.White) }
            Divider()
            ListItem(
                secondaryText = {
                    Text("Popis", color = Color.White)
                },
                trailing = {
                    Icon(
                        Icons.AutoMirrored.Default.KeyboardArrowRight,
                        "",
                        modifier = Modifier.padding(),
                        Color.White
                    )
                }) { Text("Ahoj", color = Color.White) }
        }
    }
}