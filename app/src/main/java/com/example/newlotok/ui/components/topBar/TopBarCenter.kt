package com.example.newlotok.ui.components.topBar

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.newlotok.ui.components.icons.MyAppIcons

@Composable
fun TopBarCenterText(
    text: String,
    modifier: Modifier = Modifier
){
    Text(
        text = text,
        fontWeight = FontWeight.ExtraBold,
        modifier = modifier
    )
}

@Composable
fun TopBarCenterLogo(
    modifier: Modifier = Modifier
){
    Icon(
        painter = painterResource(id = MyAppIcons.LotokLogo),
        contentDescription = null,
        modifier = modifier.scale(1.9F)
    )
}