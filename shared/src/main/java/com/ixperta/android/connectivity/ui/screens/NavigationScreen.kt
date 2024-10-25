package com.ixperta.android.connectivity.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ixperta.android.connectivity.presentation.car.CarViewModel
import com.ixperta.android.connectivity.presentation.car.SubscriptionPlans
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlanViewModel
import com.ixperta.android.connectivity.shared.R
import com.ixperta.android.connectivity.ui.components.GreenButton
import com.ixperta.android.connectivity.ui.components.PremiumButton
import com.ixperta.android.connectivity.ui.nav.Route
import com.ixperta.android.connectivity.ui.styles.AppColors

enum class NavState {
    not_found, found, navigationg
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavigationScreen(
    navController: NavHostController,
    subscriptionPlanViewModel: SubscriptionPlanViewModel,
    carViewModel: CarViewModel
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    val subscriptionPlan by carViewModel.plan.collectAsState()

    val state = remember {
        mutableStateOf<NavState>(NavState.not_found)
    }


    val searchQuery = remember {
        mutableStateOf<String?>(null)
    }


    Scaffold(topBar = {

    }) {

        Box() {
            if (state.value == NavState.navigationg || state.value == NavState.found) {
                if (subscriptionPlan == SubscriptionPlans.free || subscriptionPlan == SubscriptionPlans.basic) {
                    Image(
                        painter = painterResource(R.drawable.navi_free),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()

                    )
                } else {
                    Image(
                        painter = painterResource(R.drawable.navi_premium),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()

                    )
                }
            } else {
                Image(
                    painter = painterResource(R.drawable.navi_position),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()

                )
            }


            if (state.value == NavState.found) {
                Box(
                    modifier = Modifier
                        .width(480.dp)
                        .fillMaxHeight()
                        .align(Alignment.CenterEnd)
                        .background(AppColors.carItemBackground)
                ) {
                    Column(Modifier.padding(64.dp)) {
                        Spacer(Modifier.height(128.dp))
                        Text(searchQuery.value ?: "", fontSize = 26.sp, color = Color.White)
                        Spacer(Modifier.height(16.dp))
                        Text("Sokolovská 81/55", fontSize = 22.sp, color = Color.White)
                        Spacer(Modifier.height(16.dp))
                        Text("186 00 Praha 8-Karlín", fontSize = 22.sp, color = Color.White)
                        Spacer(Modifier.height(16.dp))
                        Text(
                            "Opening hours 15:00 - 01:00",
                            fontSize = 22.sp,
                            color = AppColors.carItemTitleColor
                        )
                        Spacer(Modifier.height(24.dp))
                        Row() {
                            Icon(
                                Icons.Default.Star,
                                "",
                                tint = Color.White,
                                modifier = Modifier.size(28.dp)
                            )
                            Icon(
                                Icons.Default.Star,
                                "",
                                tint = Color.White,
                                modifier = Modifier.size(28.dp)
                            )
                            Icon(
                                Icons.Default.Star,
                                "",
                                tint = Color.White,
                                modifier = Modifier.size(28.dp)
                            )
                            Icon(
                                Icons.Default.Star,
                                "",
                                tint = Color.White,
                                modifier = Modifier.size(28.dp)
                            )
                            Icon(
                                Icons.Default.Star,
                                "",
                                tint = Color.White,
                                modifier = Modifier.size(28.dp)
                            )

                        }
                        Spacer(Modifier.height(24.dp))
                        if (subscriptionPlan == SubscriptionPlans.free) {
                            PremiumButton({
                                state.value = NavState.not_found
                                navController.navigate(Route.Package.route)
                            }, title = "Get online route")
                        } else {
                            PremiumButton({
                                state.value = NavState.not_found
                                navController.navigate(Route.Package.route)
                            }, title = subscriptionPlan.name.uppercase())
                        }
                        Spacer(Modifier.height(32.dp))
                        Text("34 min - 12,5 km", fontSize = 24.sp, color = Color.White)


                        Spacer(Modifier.height(64.dp))
                        GreenButton({
                            state.value = NavState.navigationg
                            searchQuery.value = null
                        }, title = "Start")

                    }

                }
            }
            if (state.value == NavState.not_found || state.value == NavState.navigationg)
                Box(Modifier.align(Alignment.BottomCenter)) {
                    OutlinedTextField(
                        keyboardActions = KeyboardActions(onDone = {
                            keyboardController?.hide()
                            state.value = NavState.found
                        }),
                        singleLine = true,
                        shape = RoundedCornerShape(50),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = AppColors.carItemBackground,
                            textColor = Color.White,
                            focusedIndicatorColor = AppColors.skodaGreenColor,
                            cursorColor = AppColors.skodaGreenColor
                        ),
                        value = searchQuery.value ?: "", onValueChange = {
                            searchQuery.value = it

                        },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Search,
                                contentDescription = "search",
                                tint = AppColors.textWhiteColor
                            )
                        },

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp)
                    )

                }

        }

    }
}

