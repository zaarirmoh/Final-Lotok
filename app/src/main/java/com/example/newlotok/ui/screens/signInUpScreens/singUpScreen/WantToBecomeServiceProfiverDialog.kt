package com.example.newlotok.ui.screens.signInUpScreens.singUpScreen

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

@Composable
fun WantToBecomeServiceProviderDialog(
    signUpScreenViewModel: SignUpScreenViewModel,
    onConfirmButtonClicked: () -> Unit = {},
    onDismissButtonClicked: () -> Unit = {}
){
    if (signUpScreenViewModel.openDialog) {
        AlertDialog(
            onDismissRequest = {
                signUpScreenViewModel.openDialog = true
            },
            title = {
                Text(text = "Want to become a service provider ?")
            },
            text = {
                Text(text = "if you clikc yes , you'll need to enter your id")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        signUpScreenViewModel.openDialog = false
                        onConfirmButtonClicked()
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        signUpScreenViewModel.openDialog = false
                        onDismissButtonClicked()
                    }
                ) {
                    Text("Dismiss")
                }
            }
        )
    }
}