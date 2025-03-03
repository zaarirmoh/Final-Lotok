package com.example.newlotok.ui.screens.signInUpScreens.singUpScreen

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.HighlightOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.newlotok.ui.screens.signInUpScreens.signInScreen.EmailTextField
import com.example.newlotok.ui.screens.signInUpScreens.signInScreen.PasswordTextField

@Composable
fun SignUpTextFields(
    modifier: Modifier = Modifier,
    firstName: MutableState<String>,
    lastName: MutableState<String>,
    emailAddress: MutableState<String>,
    password: MutableState<String>,
    confirmPassword: MutableState<String>,
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
    ){
        UserNameTextField(
            name = firstName,
        )
        Spacer(modifier = modifier.height(20.dp))
        UserNameTextField(
            name = lastName,
        )
        Spacer(modifier = modifier.height(20.dp))
        EmailTextField(
            emailAddress = emailAddress,
        )
        Spacer(modifier = modifier.height(20.dp))
        PasswordTextField(
            supportingText = { Text(text = "example: At least 8 characters") },
            password = password,
        )
        Spacer(modifier = modifier.height(20.dp))
        PasswordTextField(
            supportingText = { Text(text = "example: At least 8 characters") },
            password = confirmPassword,
        )
    }
}
@Composable
fun UserNameTextField(
    modifier: Modifier = Modifier,
    name: MutableState<String>,
){
    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        value = name.value,
        onValueChange = {name.value = it},
        label = { Text(text = "User name") },
        placeholder = { Text(text = "example",color = Color(0xFF7D848D)) },
        trailingIcon = {
            IconButton(onClick = { name.value = "" }) {
                Icon(
                    imageVector = Icons.Outlined.HighlightOff,
                    contentDescription = null
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
        ),
        keyboardActions = KeyboardActions(onDone = {
            keyboardController?.hide()
        }),
        modifier = modifier.fillMaxWidth(),
    )
}