package com.example.newlotok.ui.screens.orderDetailsScreen

import android.content.Context
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.model.OrderDetails
import com.example.newlotok.ui.navigation.LotokScreen

fun NavGraphBuilder.orderDetailsScreenNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    uiState: OrderDetails,
    context: Context
){
    composable(route = LotokScreen.OrderDetailsScreen.name){
        OrderDetailsScreen(
            uiState = uiState ,
            context = context,
            onDoneButtonClicked = {
                navController.navigate(LotokScreen.HomeScreen.name)
            },

        )
    }
}