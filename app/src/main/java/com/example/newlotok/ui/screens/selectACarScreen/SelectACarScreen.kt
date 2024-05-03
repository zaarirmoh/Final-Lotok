package com.example.newlotok.ui.screens.selectACarScreen

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.newlotok.ui.components.topBar.EndIconProfile
import com.example.newlotok.ui.components.topBar.StartIconGoBack
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.components.topBar.TopBarCenterText


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SelectACarScreen(
    onProfileIconClicked: () -> Unit = {},
    onGoBackIconClicked: () -> Unit = {},
    onHomeIconClicked: () -> Unit = {}
){
    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconGoBack(onButtonClicked = onGoBackIconClicked) }, //StartIconMenu()
                topBarCenter = { TopBarCenterText(text = "Select your car") },   //TopBarCenterText(text = "Home")
                endIcon = { EndIconProfile(onButtonClicked = onProfileIconClicked) }
            )
        }
    ) {

    }
}