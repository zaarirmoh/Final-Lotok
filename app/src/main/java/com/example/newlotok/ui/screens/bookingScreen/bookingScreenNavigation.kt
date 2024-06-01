package com.example.newlotok.ui.screens.bookingScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.model.Data
import com.example.newlotok.ui.navigation.LotokScreen

fun NavGraphBuilder.bookingScreenNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    bookingSharedViewModel: BookingSharedViewModel
){
    composable(route = LotokScreen.BookingScreen.name){
        BookingScreen(
            carPost = Data.carPostsList[0],
            bookingSharedViewModel = bookingSharedViewModel,
            bookNowButtonClicked = {
                navController.navigate(LotokScreen.OrderDetailsScreen.name)
            }
        )
    }
}
