package com.example.newlotok.ui.components.topBar

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.newlotok.ui.components.icons.MyAppIcons
import com.example.lotok.ui.theme.StartIconHomeColor

@Composable
fun EndIconNotification(
    onButtonClicked: () -> Unit = {}
){
    IconButton(onClick = onButtonClicked) {
        Icon(
            imageVector = MyAppIcons.Notification,
            contentDescription = null,
            tint = StartIconHomeColor
        )
    }
}

@Composable
fun EndIconProfile(
    onButtonClicked: () -> Unit = {}
){
    IconButton(onClick = onButtonClicked) {
        Icon(
            painter = painterResource(id = MyAppIcons.Profile),
            contentDescription = null
        )
    }
}
@Composable
fun EndIconEdit(
    onButtonClicked: () -> Unit = {}
){
    IconButton(onClick = onButtonClicked) {
        Icon(
            painter = painterResource(id = MyAppIcons.Edit),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
    }
}
@Composable
fun EndIconDone(
    onButtonClicked: () -> Unit = {}
){
    TextButton(onClick = onButtonClicked) {
        Text(
            text = "Done",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}