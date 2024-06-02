package com.example.newlotok.ui.screens.signInUpScreens.singUpScreen

import androidx.lifecycle.ViewModel
import com.example.newlotok.data.LotokRepository

sealed interface SignUpScreenUiState {
    data class Success(
        val refreshToken: String,
        val accessToken: String
    ) : SignUpScreenUiState
    object Error : SignUpScreenUiState
    object Loading : SignUpScreenUiState
}

class SignUpScreenViewModel (private val lotokRepository: LotokRepository) : ViewModel() {

}