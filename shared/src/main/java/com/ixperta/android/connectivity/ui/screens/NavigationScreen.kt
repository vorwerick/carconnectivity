package com.ixperta.android.connectivity.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.ixperta.android.connectivity.presentation.car.CarViewModel
import com.ixperta.android.connectivity.presentation.car.SubscriptionPlans
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlanViewModel
import com.ixperta.android.connectivity.ui.components.GreenButton
import com.ixperta.android.connectivity.ui.styles.AppColors

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavigationScreen(
    navController: NavHostController,
    subscriptionPlanViewModel: SubscriptionPlanViewModel,
    carViewModel: CarViewModel
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val subscriptionPlan by carViewModel.plan.collectAsState()

    val myCarCoords = LatLng(40.9971, 29.1007)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(myCarCoords, 5f)
    }
    val uiSettings by remember {
        mutableStateOf(
            MapUiSettings(
                zoomControlsEnabled = false,
                myLocationButtonEnabled = true,
                tiltGesturesEnabled = subscriptionPlan != SubscriptionPlans.free
            )
        )
    }
    val properties by remember {
        mutableStateOf(
            MapProperties(
                mapType = MapType.NORMAL,
                isBuildingEnabled = true,
                isIndoorEnabled = true,
            )
        )
    }

    val searchQuery = remember {
        mutableStateOf<String?>(null)
    }

    val find = remember {
        mutableStateOf<Boolean>(false)
    }
    Scaffold(topBar = {

    }) {

        Box() {
            GoogleMap(

                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                properties = properties,
                uiSettings = uiSettings

            ) {


                Marker(
                    state = MarkerState(position = myCarCoords),
                    title = "One Marker"
                )
            }

            if (find.value) {
                Box(
                    modifier = Modifier
                        .width(420.dp)
                        .fillMaxHeight()
                        .background(AppColors.carItemBackground)
                ) {
                    Column(Modifier.padding(32.dp)) {
                        Spacer(Modifier.height(200.dp))
                        Text(searchQuery.value?: "", fontSize = 26.sp, color = Color.White)
                        Spacer(Modifier.height(16.dp))
                        Text("Sokolovská 81/55", fontSize = 22.sp, color = Color.White)
                        Spacer(Modifier.height(16.dp))
                        Text("186 00 Praha 8-Karlín", fontSize = 22.sp, color = Color.White)
                        Spacer(Modifier.height(16.dp))
                        Text("Opening hours 15:00 - 01:00", fontSize = 22.sp, color = AppColors.carItemTitleColor)
                        Spacer(Modifier.height(48.dp))
                        GreenButton({}, title = "Get online route")

                    }

                }
            }
            Box(Modifier.align(Alignment.BottomCenter)) {
                OutlinedTextField(
                    keyboardActions = KeyboardActions(onDone = {
                        keyboardController?.hide()
                        find.value = true
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

