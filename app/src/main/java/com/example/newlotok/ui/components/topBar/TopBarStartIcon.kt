package com.example.newlotok.ui.components.topBar

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.newlotok.ui.components.icons.MyAppIcons
import com.example.newlotok.ui.theme.StartIconHomeColor

@Composable
fun StartIconMenu(
    modifier: Modifier = Modifier,
    onButtonClicked: () -> Unit = {}
){
    IconButton(onClick = onButtonClicked) {
        Icon(
            imageVector = MyAppIcons.Menu,
            contentDescription = null,
            tint = StartIconHomeColor,
            modifier = modifier
        )
    }
}

@Composable
fun StartIconGoBack(
    onButtonClicked: () -> Unit = {}
){
    Card(
        shape = RoundedCornerShape(100),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF7F7F9)
        )
    ) {
        IconButton(onClick = onButtonClicked) {
            Icon(
                imageVector = MyAppIcons.GoBack,
                contentDescription = null,
                tint = Color(0xFF1B1E28)
            )
        }
    }
}