package com.example.lotok.ui.screens.signInUpScreens.signInUpComponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SignInUpButton(
    modifier: Modifier = Modifier,
    onSignInButtonClicked: () -> Unit = {},
    text: String
){
    Button(
        onClick = onSignInButtonClicked,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .height(56.dp)
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.surface
        )
    }
}