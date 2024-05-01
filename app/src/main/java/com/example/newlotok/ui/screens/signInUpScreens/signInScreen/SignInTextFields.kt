package com.example.lotok.ui.screens.signInUpScreens.signInScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.HighlightOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun SignInTextFields(
    modifier: Modifier = Modifier,
    onForgotPasswordTextClicked: () -> Unit
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
    ){
        EmailTextField()
        Spacer(modifier = modifier.height(20.dp))
        PasswordTextField(supportingText = {
            ForgotPasswordTextButton(onForgotPasswordButtonClicked = onForgotPasswordTextClicked)
        })
    }
}
@Composable
fun EmailTextField(
    modifier: Modifier = Modifier
){
    val keyboardController = LocalSoftwareKeyboardController.current
    var text by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = {text = it},
        label = { Text(text = "Email address") },
        placeholder = { Text(text = "example",color = Color(0xFF7D848D)) },
        suffix = { Text(text = "@gmail.com") },
        trailingIcon = {
            IconButton(onClick = { text = "" }) {
                Icon(
                    imageVector = Icons.Outlined.HighlightOff,
                    contentDescription = null
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Email
        ),
        keyboardActions = KeyboardActions(onDone = {
            keyboardController?.hide()
        }),
        modifier = modifier.fillMaxWidth(),
    )
}
@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    supportingText: @Composable () -> Unit = {
        Text(
            text = "",
            color = Color(0xFF7D848D),
        )
    }

){
    val keyboardController = LocalSoftwareKeyboardController.current
    var text1 by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    OutlinedTextField(
        value = text1,
        onValueChange = {text1 = it},
        label = { Text(text = "Password") },
        placeholder = { Text(text = "*********",color = Color(0xFF7D848D)) },
        suffix = { Text(text = "") },
        trailingIcon = {
            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                val visibilityIcon =
                    if (!passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                Icon(imageVector = visibilityIcon, contentDescription = null)
            } },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        keyboardActions = KeyboardActions(onDone = {
            keyboardController?.hide()
        }),
        visualTransformation =
        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        supportingText = supportingText,
        modifier = modifier.fillMaxWidth()
    )

}