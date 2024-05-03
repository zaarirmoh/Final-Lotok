package com.example.newlotok.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.newlotok.ui.components.navigationBar.MyNavigationBar

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
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = LotokScreen.valueOf(
        backStackEntry?.destination?.route ?: LotokScreen.HomeScreen.name
    )
    Scaffold(
        bottomBar = {
            // Get current back stack entry

            if(currentScreen.hasNavigationBar) MyNavigationBar(navController = navController)
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = modifier.padding(it)
        ) {
            navigationSystem(
                navController = navController,
                scrollBehavior = scrollBehavior,
                onWelcomeScreenButtonClicked = onWelcomeScreenButtonClicked
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