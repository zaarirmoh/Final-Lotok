package com.example.newlotok.ui.screens.signInUpScreens.signInScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.newlotok.LotokApplication
import com.example.newlotok.data.LotokRepository
import com.example.newlotok.model.MarsPhoto
import com.example.newlotok.model.SignIn
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface SignInScreenUiState {
    data class Success(
        val refreshToken: String,
        val accessToken: String
    ) : SignInScreenUiState
    object Error : SignInScreenUiState
    object Loading : SignInScreenUiState
}

class SignInScreenViewModel(private val lotokRepository: LotokRepository) : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var signInScreenUiState: SignInScreenUiState by mutableStateOf(SignInScreenUiState.Loading)
        private set

    var emailAddress: String by mutableStateOf("")
    var password: String by mutableStateOf("")

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    fun postUserInformation() {
        viewModelScope.launch {
            signInScreenUiState = SignInScreenUiState.Loading
            signInScreenUiState = try {
                val signInInformation = SignIn(
                    email = emailAddress,
                    password = password
                )
                val tokens = lotokRepository.signIn(
                    signInInformation = signInInformation
                )
                // to be removed
                Log.d(null, tokens.accessToken)
                Log.d(null, tokens.refreshToken)
                SignInScreenUiState.Success(
                    refreshToken = tokens.refreshToken,
                    accessToken = tokens.accessToken
                )


            } catch (e: IOException){
                Log.d(null, "exception")
                SignInScreenUiState.Error
            } catch (e: HttpException){
                Log.e(null, e.message())
                SignInScreenUiState.Error
            }
            /*
            signInScreenUiState = try {
                HomeScreenUiState.Success(
                    lotokRepository.getCarPosts(),
                    lotokRepository.getCategories()
                )
            } catch (e: IOException) {
                HomeScreenUiState.Error
            } catch (e: HttpException) {
                HomeScreenUiState.Error
            }
             */
        }
    }

    /**
     * Factory for [HomeScreenViewModel] that takes [LotokRepository] as a dependency
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as LotokApplication)
                val marsPhotosRepository = application.container.lotokRepository
                SignInScreenViewModel(lotokRepository = marsPhotosRepository)
            }
        }
    }
}