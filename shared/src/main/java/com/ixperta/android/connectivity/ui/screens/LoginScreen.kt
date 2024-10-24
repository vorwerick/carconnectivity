package com.ixperta.android.connectivity.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ixperta.android.connectivity.presentation.auth.AuthViewModel
import com.ixperta.android.connectivity.ui.components.GreenButton
import com.ixperta.android.connectivity.ui.styles.AppColors
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(authViewModel: AuthViewModel) {

    val scope = rememberCoroutineScope()
    Scaffold(backgroundColor = AppColors.background) {
        // State variables to store user input
        val userName = remember {
            mutableStateOf("")
        }
        val userPassword = remember {
            mutableStateOf("")
        }

        // Column to arrange UI elements vertically
        Column(

        ) {
            Box(
                Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    "Login",
                    modifier = Modifier.padding(start = 24.dp, top = 32.dp, bottom = 32.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                )

            }

            Card(
                backgroundColor = AppColors.background,
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                shape = RoundedCornerShape(10),
            ) {
                Column(modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(24.dp)) {
                    OutlinedTextField(
                        shape = RoundedCornerShape(50),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = AppColors.carItemBackground,
                            textColor = Color.White,
                            focusedIndicatorColor = AppColors.skodaGreenColor,
                            cursorColor = AppColors.skodaGreenColor
                        ),
                        value = userName.value, onValueChange = {
                            userName.value = it
                        },
                        label = {
                            Text("email", color = Color.White)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                    )

                    OutlinedTextField(

                        shape = RoundedCornerShape(50),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = AppColors.carItemBackground,
                            textColor = Color.White,
                            focusedIndicatorColor = AppColors.skodaGreenColor,
                            cursorColor = AppColors.skodaGreenColor
                        ),
                        value = userPassword.value, onValueChange = {
                            userPassword.value = it
                        },
                        label = {
                            Text("password", color = Color.White)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp),
                        visualTransformation = PasswordVisualTransformation()
                    )

                    Spacer(Modifier.height(24.dp))
                    GreenButton({
                       scope.launch {
                           authViewModel.login(userName.value, userPassword.value)

                       }

                    }, "Login")
                }
            }

        }
    }
}