package com.example.lotok.ui.screens.signInUpScreens.forgotPasswordScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ForgotPasswordAlertDialog(
    modifier: Modifier = Modifier,
    openDialog: MutableState<Boolean> = mutableStateOf(false),
    onForgotPasswordButtonClicked: () -> Unit = {}
){
    if (openDialog.value) {
        LaunchedEffect(true) {
            coroutineScope {
                launch {
                    delay(2000)
                }
            }
            onForgotPasswordButtonClicked()
        }
        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onDismissRequest.
                openDialog.value = true
            },
            icon = { ForgotPasswordAlertDialogIcon() },
            title = {
                Text(
                    text = "Check your email",
                    textAlign = TextAlign.Center
                )
            },
            text = {
                Text(
                    text = "We have sent password recovery instructions to your email",
                    textAlign = TextAlign.Center
                )
            },
            confirmButton = {

            },
            dismissButton = {

            }
        )
    }
}
@Preview
@Composable
fun ForgotPasswordAlertDialogIcon(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .size(44.dp)
            .background(shape = CircleShape, color = MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ){
        Icon(
            imageVector = Icons.Outlined.Email,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.surface,
            modifier = modifier.size(26.dp)
        )
    }
}
@Composable
fun ForgotPasswordAlertDialogTitle(
    modifier: Modifier = Modifier
){

}