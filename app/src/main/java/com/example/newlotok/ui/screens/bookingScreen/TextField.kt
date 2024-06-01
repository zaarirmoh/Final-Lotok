package com.example.newlotok.ui.screens.bookingScreen

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(
    modifier: Modifier = Modifier,
    value : String = "",
    onValueChange : (String) -> Unit = {},
    labelText : String,
    labelTextWarning: String,
    singleLine : Boolean = true,
    placeHolderText : String,
    imageVector: ImageVector,
    keyboardOptions : KeyboardOptions,
    condition : (String) -> Boolean,

){

    val keyboardController = LocalSoftwareKeyboardController.current
    var isValid by remember { mutableStateOf(true) }
    val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = if (!isValid) Color.Red else Color(0xFF7D848D)
    )
    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChange(it)
            isValid = condition(it)

        },
        label = {
            Text(
                text = if (isValid)labelText else labelTextWarning,
                color = if (isValid) Color(0xFF7D848D) else Color.Red
            )

        },
        placeholder = {
            Text(
                text = placeHolderText,
                color = if (isValid) Color(0xFF7D848D) else Color.Red
            )
        },

        trailingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = null
            )
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = KeyboardActions(onDone = {
            keyboardController?.hide()
        }),
        singleLine = singleLine,

        colors = textFieldColors,
        modifier = modifier.height(60.dp)

    )
}