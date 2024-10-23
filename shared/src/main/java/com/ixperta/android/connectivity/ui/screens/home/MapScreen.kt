package com.ixperta.android.connectivity.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlanState
import com.ixperta.android.connectivity.presentation.subscriptions.SubscriptionPlanViewModel
import com.ixperta.android.connectivity.ui.nav.Route
import com.ixperta.android.connectivity.ui.styles.AppColors
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MapScreen(
    navController: NavHostController,
    subscriptionPlanViewModel: SubscriptionPlanViewModel
) {
    val scope = rememberCoroutineScope()
    val subscriptionPlan by subscriptionPlanViewModel.subscriptionPlan.collectAsState()

    val sheetState = androidx.compose.material3.rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(subscriptionPlan is SubscriptionPlanState.Free) }
    val myCarCoords = LatLng(40.9971, 29.1007)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(myCarCoords, 5f)
    }

    val uiSettings by remember {
        mutableStateOf(MapUiSettings(zoomControlsEnabled = false))
    }
    val properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.NORMAL))
    }

    val searchQuery = remember {
        mutableStateOf("")
    }

    Scaffold(topBar = {

    }) {
        if (showBottomSheet) {
            ModalBottomSheet(

                dragHandle = null,
                onDismissRequest = {
                },
                sheetState = sheetState
            ) {
                // Sheet content
                Button(onClick = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            showBottomSheet = false
                        }
                        navController.navigate(Route.SubscriptionPlans.route)
                    }
                }) {
                    Text("Hide bottom sheet")
                }
            }
        }
        Box() {
            var modifier = Modifier.blur(10.dp)
            if (subscriptionPlan != SubscriptionPlanState.Free)
                modifier = Modifier.blur(0.dp)
            Box(modifier = modifier) {
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
            }
            OutlinedTextField(
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = AppColors.carItemBackground,
                    textColor = Color.White,
                    focusedIndicatorColor = AppColors.skodaGreenColor,
                    cursorColor = AppColors.skodaGreenColor
                ),
                value = searchQuery.value, onValueChange = {
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

