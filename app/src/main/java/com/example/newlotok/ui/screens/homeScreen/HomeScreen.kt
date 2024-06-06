package com.example.newlotok.ui.screens.homeScreen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.newlotok.model.CarPost
import com.example.newlotok.model.Category
import com.example.newlotok.ui.components.datePickers.DateRangePicker
import com.example.newlotok.ui.components.topBar.EndIconNotification
import com.example.newlotok.ui.components.topBar.StartIconMenu
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.components.topBar.TopBarCenterLogo
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNotificationIconClicked: () -> Unit = {},
    onMenuIconClicked: () -> Unit = {},
    onSearchForACarButtonClicked: () -> Unit = {},
    openDialog: MutableState<Boolean>,
    expendedMenu: MutableState<Boolean>,
    onSettingsClicked: () -> Unit = {},
    carPosts: List<CarPost> = listOf(),
    categories: List<Category> = listOf(),
    scrollBehavior: TopAppBarScrollBehavior,
    isLoading: Boolean = false,
    onBookNowButtonClicked: (carPost: CarPost) -> Unit,
    onYearSelected: (year: Int) -> Unit,
    onStateSelected: (state: Int) -> Unit,
) {
    val navigationBarHeight = 90
    val expandedYears = remember { mutableStateOf(false) }
    val expandedStates = remember { mutableStateOf(false) }

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
                endIcon = { EndIconNotification(onButtonClicked = onNotificationIconClicked) },
                scrollBehavior = scrollBehavior
            )

        }
    ){ paddingContent ->
        Column(
            modifier = modifier
                .padding(paddingContent)
                //.padding(bottom = navigationBarHeight.dp)
                .verticalScroll(rememberScrollState())
        ){
            Spacer(modifier = modifier.height(11.dp))
            SearchForACar(onSearchForACarButtonClicked = onSearchForACarButtonClicked)
            Spacer(modifier = modifier.height(32.dp))
            FilterCars(
                onStateButtonClicked = {},
                onFromToButtonClicked = {openDialog.value = !openDialog.value},
                expandedYears = expandedYears,
                expandedStates = expandedStates,
            )
            Spacer(modifier = modifier.height(25.dp))
            Categories(categories = categories)
            Spacer(modifier = modifier.height(25.dp))
            PopularCars(
                carPosts = carPosts,
                onBookNowButtonClicked = onBookNowButtonClicked
            )
        }
        DateRangePicker(openDialog = openDialog)
        ChooseYearDialog(
            openDialog = expandedYears,
            onYearSelected = {
                onYearSelected(it)
                Log.d("Year", it.toString())
                expandedYears.value = false
            },
        )
        ChooseStateDialog(
            openDialog = expandedStates,
            onStateSelected = {
                onStateSelected(it)
                Log.d("State", it.toString())
                expandedStates.value = false
            },
        )
    }
}