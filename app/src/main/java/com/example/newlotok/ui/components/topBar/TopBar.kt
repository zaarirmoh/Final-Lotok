package com.example.newlotok.ui.components.topBar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    startIcon: @Composable () -> Unit = {},
    topBarCenter: @Composable () -> Unit = {},
    endIcon: @Composable (RowScope.() -> Unit) = {},
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
){
    CenterAlignedTopAppBar(
        title = topBarCenter,
        navigationIcon = startIcon,
        actions = endIcon,
        scrollBehavior = scrollBehavior
    )
}

