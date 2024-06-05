package com.example.newlotok.ui.navigation

import android.content.Context
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.newlotok.ui.TokensViewModel
import com.example.newlotok.ui.components.navigationBar.MyNavigationBar
import com.example.newlotok.ui.screens.addPostScreen.AddPostScreenViewModel
import com.example.newlotok.ui.screens.bookingScreen.BookingSharedViewModel
import com.example.newlotok.ui.screens.signInUpScreens.signInScreen.SignInScreenViewModel

// ToDo: Try to Extract the scaffold out so all the screen have like one topAppBar and one NavigationBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LotokNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    onWelcomeScreenButtonClicked: () -> Unit ,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    scrollBehavior: TopAppBarScrollBehavior,
    startDestination: String,
    addPostRoute: String,
    tokensViewModel: TokensViewModel
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = LotokScreen.valueOf(
        backStackEntry?.destination?.route ?: LotokScreen.HomeScreen.name
    )
    val context : Context = LocalContext.current
    val bookingSharedViewModel: BookingSharedViewModel
        = viewModel(factory = BookingSharedViewModel.Factory)
    val addPostScreenViewModel: AddPostScreenViewModel
        = viewModel(factory = AddPostScreenViewModel.Factory)
    val uiState by bookingSharedViewModel.uiState.collectAsState()
    Scaffold(
        bottomBar = {
            // Get current back stack entry

            if(currentScreen.hasNavigationBar) MyNavigationBar(
                navController = navController,
                onAddPostClicked = addPostRoute
            )
        }
    ) {

        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = modifier.padding(it),
            enterTransition = { fadeIn(animationSpec = tween(100)) },
            exitTransition = { fadeOut(animationSpec = tween(100)) }
        ) {
            navigationSystem(
                navController = navController,
                scrollBehavior = scrollBehavior,
                onWelcomeScreenButtonClicked = onWelcomeScreenButtonClicked,
                context = context,
                bookingSharedViewModel = bookingSharedViewModel,
                uiState = uiState,
                addPostScreenViewModel = addPostScreenViewModel,
                tokensViewModel = tokensViewModel
            )
        }
    }
}

// maybe i'll try this later
/**
 * topBar = {
 *                  AllTopBars(currentScreen = currentScreen)
 *         },
 */