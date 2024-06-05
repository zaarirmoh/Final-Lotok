package com.example.newlotok.ui.screens.bookingScreen

import android.util.Log
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.model.Data
import com.example.newlotok.ui.TokensViewModel
import com.example.newlotok.ui.navigation.LotokScreen

fun NavGraphBuilder.bookingScreenNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    bookingSharedViewModel: BookingSharedViewModel,
    tokensViewModel: TokensViewModel
){
    composable(route = LotokScreen.BookingScreen.name){
        Log.d(null, "correct until here")
        BookingScreen(
            carPost = tokensViewModel.carPost ?: Data.carPostsList[0],
            bookingSharedViewModel = bookingSharedViewModel,
            onBookNowButtonClicked = {
                bookingSharedViewModel.postBooking(bookingSharedViewModel.uiState.value)
            },
            navController = navController
        )
    }

}
