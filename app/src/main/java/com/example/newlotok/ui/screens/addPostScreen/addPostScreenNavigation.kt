package com.example.newlotok.ui.screens.addPostScreen

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.ui.navigation.LotokScreen

fun NavGraphBuilder.addPostScreenNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
){
    composable(route = LotokScreen.AddPostScreen.name){
        AddPostScreen(onGoBackIconClicked = { }) {

        }
    }
}