package com.example.newlotok.ui.screens.addPostScreen

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.newlotok.model.CarPost
import com.example.newlotok.ui.TokensViewModel
import com.example.newlotok.ui.navigation.LotokScreen
import com.google.firebase.Firebase
import com.google.firebase.storage.storage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

fun NavGraphBuilder.addPostScreenNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    addPostScreenViewModel: AddPostScreenViewModel,
    tokensViewModel: TokensViewModel,

){

    composable(route = LotokScreen.AddPostScreen.name){
        val context = LocalContext.current
        var carPost: CarPost? = null
        val shouldAddPost = remember { mutableStateOf(false) }
        var authorization = "Bearer "
        AddPostScreen(
            onGoBackIconClicked = { navController.navigateUp()},
            addPostScreenViewModel = addPostScreenViewModel,
            onConfirmButtonClicked = {},
            onAddPostButtonClicked = {
                Log.d("vin",addPostScreenViewModel.uiState.value.vin)
                shouldAddPost.value = true
            },
            onProfileIconClicked = {navController.navigate(LotokScreen.ProfileScreen.name)}
        )
        if(shouldAddPost.value){
            Log.d("entered here","entered here")
            LaunchedEffect(Unit){
                delay(1000)
                Log.d("vin", addPostScreenViewModel.uiState.value.vin)
                Log.d("entered here 2","entered here 2")
                authorization += tokensViewModel.getAccessToken(context)
                Log.d("authorization",authorization)
                Log.d("les donnees",addPostScreenViewModel.uiState.value.toString())
                carPost = CarPost(
                    vin = addPostScreenViewModel.uiState.value.vin,
                    make = addPostScreenViewModel.uiState.value.make,
                    model = addPostScreenViewModel.uiState.value.model,
                    description = addPostScreenViewModel.uiState.value.description,
                    location = addPostScreenViewModel.uiState.value.wilaya + 1,
                    dayPrice = addPostScreenViewModel.uiState.value.dailyPrice,
                    weekPrice = addPostScreenViewModel.uiState.value.weeklyPrice,
                    id = 50,
                    year = addPostScreenViewModel.uiState.value.year,
                    engine = addPostScreenViewModel.uiState.value.engine,
                    power = addPostScreenViewModel.uiState.value.power,
                    fuel = addPostScreenViewModel.uiState.value.fuel,
                    imgSrc = addPostScreenViewModel.uiState.value.carPictures[0].toString(),
                    body = addPostScreenViewModel.uiState.value.body,
                    transmission = addPostScreenViewModel.uiState.value.transmission,
                    category = 1,
                    isVerified = true,
                    rating = 0.0,
                    userId = addPostScreenViewModel.getID(context)
                )
                addPostScreenViewModel.addCarPost(authorization = authorization, carPost = carPost!!)
            }
        }
        if(addPostScreenViewModel.shouldNavigate){
            navController.navigate(LotokScreen.HomeScreen.name)
            Toast.makeText(context, "post added successfully", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "failed to add post or fill required fields", Toast.LENGTH_SHORT).show()
        }
    }
}