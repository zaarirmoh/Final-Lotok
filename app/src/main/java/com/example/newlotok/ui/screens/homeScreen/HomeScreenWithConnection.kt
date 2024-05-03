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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.newlotok.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenWithConnection(
    homeScreenUiState: HomeScreenUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    scrollBehavior: TopAppBarScrollBehavior,
) {
    val expandedMenu = remember { mutableStateOf(false) }
    val openDialog = remember { mutableStateOf(false) }
    when (homeScreenUiState) {
        is HomeScreenUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is HomeScreenUiState.Success -> HomeScreen(
            openDialog = openDialog,
            expendedMenu = expandedMenu,
            categories = homeScreenUiState.categories,
            carPosts = homeScreenUiState.carPosts,
            scrollBehavior = scrollBehavior
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
            Text("here we go")
        }
    }
}