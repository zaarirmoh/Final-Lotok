package com.example.newlotok.ui.components.topBar

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import com.example.newlotok.ui.components.icons.MyAppIcons

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