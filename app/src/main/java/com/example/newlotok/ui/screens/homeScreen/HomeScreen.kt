package com.example.lotok.ui.screens.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newlotok.ui.components.datePickers.DateRangePicker
import com.example.newlotok.ui.components.topBar.EndIconNotification
import com.example.newlotok.ui.components.topBar.StartIconMenu
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.components.topBar.TopBarCenterLogo
import com.example.newlotok.ui.screens.homeScreen.Categories
import com.example.newlotok.ui.screens.homeScreen.FilterCars
import com.example.newlotok.ui.screens.homeScreen.PopularCars
import com.example.newlotok.ui.screens.homeScreen.SearchForACar


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNotificationIconClicked: () -> Unit = {},
    onMenuIconClicked: () -> Unit = {},
    onSearchForACarButtonClicked: () -> Unit = {},
    openDialog: MutableState<Boolean>,
    expendedMenu: MutableState<Boolean>,
    onSettingsClicked: () -> Unit = {}
) {
    val navigationBarHeight = 90
    Scaffold(
        topBar = {
            TopBar(
                startIcon = {
                    StartIconMenu(onButtonClicked = onMenuIconClicked)
                    ExpendMenu(
                        expanded = expendedMenu,
                        onSettingsClicked = onSettingsClicked
                    ) }, //StartIconMenu()
                topBarCenter = { TopBarCenterLogo() },   //TopBarCenterText(text = "Home")
                endIcon = { EndIconNotification(onButtonClicked = onNotificationIconClicked) }
            )
        }
    ){ paddingContent ->
        Column(
            modifier = modifier
                .padding(paddingContent)
                .padding(bottom = navigationBarHeight.dp)
                .verticalScroll(rememberScrollState())
        ){
            Spacer(modifier = modifier.height(11.dp))
            SearchForACar(onSearchForACarButtonClicked = onSearchForACarButtonClicked)
            Spacer(modifier = modifier.height(32.dp))
            FilterCars(
                onStateButtonClicked = {},
                onFromToButtonClicked = {openDialog.value = !openDialog.value}
            )
            Spacer(modifier = modifier.height(25.dp))
            Categories()
            Spacer(modifier = modifier.height(25.dp))
            PopularCars()
        }
        DateRangePicker(openDialog = openDialog)
    }
}