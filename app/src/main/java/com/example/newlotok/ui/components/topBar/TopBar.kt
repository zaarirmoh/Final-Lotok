package com.example.newlotok.ui.components.topBar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    startIcon: @Composable () -> Unit = {} ,
    topBarCenter: @Composable () -> Unit = {} ,
    endIcon: @Composable (RowScope.() -> Unit) = {} ,
){
    CenterAlignedTopAppBar(
        title = topBarCenter,
        navigationIcon = startIcon,
        actions = endIcon,
    )
}

@Preview
@Composable
fun TopBarPreview(){
    Surface(color = Color.White, modifier = Modifier.fillMaxSize()){
        TopBar(
            startIcon = { StartIconMenu() },
            topBarCenter = { TopBarCenterText(text = "Home") },
            endIcon = { EndIconNotification() }
        )
    }

}