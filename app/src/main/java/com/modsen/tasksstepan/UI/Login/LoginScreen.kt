package com.modsen.tasksstepan.UI.Login

import android.graphics.Color
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.firebase.FirebaseApp
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                is LoginEvent.AuthorizationMessage -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_LONG).show()
                }
                //код для навигации на другой экран
                is LoginEvent.NavigeteToNextScreen->{
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = state.login,
            onValueChange ={ viewModel.onIntent(LoginIntent.EnterUsername(it)) },
            label = { Text("Login") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = state.password,
            onValueChange ={ viewModel.onIntent(LoginIntent.EnterPassword(it)) },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedButton(
            onClick = {viewModel.onIntent(LoginIntent.Submit)},
            enabled = state.login.isNotBlank() && state.password.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            if (state.isLoading){
                CircularProgressIndicator()
            }else{
                Text("Authorize")
            }
        }
    }
}
