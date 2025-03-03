package com.example.newlotok.ui.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.newlotok.R
import com.example.newlotok.model.CarPost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenWithConnection(
    homeScreenUiState: HomeScreenUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    scrollBehavior: TopAppBarScrollBehavior,
    openDialog: MutableState<Boolean>,
    expendedMenu: MutableState<Boolean>,
    onMenuIconClicked: () -> Unit,
    onSearchForACarButtonClicked: () -> Unit,
    onSettingsClicked: () -> Unit,
    onBookNowButtonClicked: (carPost: CarPost) -> Unit,
    onYearSelected: (year: Int) -> Unit,
    onStateSelected: (state: Int) -> Unit

) {
    when (homeScreenUiState) {
        is HomeScreenUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is HomeScreenUiState.Success -> HomeScreen(
            openDialog = openDialog,
            expendedMenu = expendedMenu,
            categories = homeScreenUiState.categories,
            carPosts = homeScreenUiState.carPosts,
            scrollBehavior = scrollBehavior,
            onMenuIconClicked = onMenuIconClicked,
            onSearchForACarButtonClicked = onSearchForACarButtonClicked,
            onSettingsClicked = onSettingsClicked,
            modifier = modifier.padding(contentPadding),
            onBookNowButtonClicked = onBookNowButtonClicked,
            onYearSelected = onYearSelected,
            onStateSelected = onStateSelected,
        )

        is HomeScreenUiState.Error -> ErrorScreen(retryAction, modifier = modifier.fillMaxSize())
    }

}

/**
 * The home screen displaying the loading message.
 */
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = null
    )
}

/**
 * The home screen displaying error message with re-attempt button.
 */
@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = "", modifier = Modifier.padding(16.dp))
        Button(onClick = retryAction) {
            Text("Reload page")
        }
    }
}