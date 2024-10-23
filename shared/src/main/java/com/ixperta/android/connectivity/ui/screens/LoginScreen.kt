package com.ixperta.android.connectivity.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ixperta.android.connectivity.presentation.auth.AuthViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(authViewModel: AuthViewModel) {
    Scaffold(backgroundColor = Color.Black) {
        // State variables to store user input
        val userName = remember {
            mutableStateOf("")
        }
        val userPassword = remember {
            mutableStateOf("")
        }

        // Column to arrange UI elements vertically
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(40.dp)
        ) {

            // Welcome message
            Text(
                text = "Login", fontSize = 28.sp, color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 50.dp, 0.dp, 0.dp)
            )

            // Username input field
            OutlinedTextField(
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Black),
                value = userName.value, onValueChange = {
                    userName.value = it
                },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "person")
                },
                label = {
                    Text(text = "username")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 20.dp, 0.dp, 0.dp)
            )

            // Password input field
            OutlinedTextField(
                value = userPassword.value, onValueChange = {
                    userPassword.value = it
                },
                leadingIcon = {
                    Icon(Icons.Default.Info, contentDescription = "password")
                },
                label = {
                    Text(text = "password")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 20.dp, 0.dp, 0.dp),
                visualTransformation = PasswordVisualTransformation()
            )

            // Login button
            OutlinedButton(
                onClick = {
                    authViewModel.login(userName.value, userPassword.value)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 25.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = "Login",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }
        }
    }
}