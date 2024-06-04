package com.example.newlotok.ui.screens.signInUpScreens.singUpScreen

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
import com.example.newlotok.model.SignUp
import com.example.newlotok.ui.screens.signInUpScreens.signInScreen.SignInScreenUiState
import com.example.newlotok.ui.screens.signInUpScreens.signInScreen.SignInScreenViewModel
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException

sealed interface SignUpScreenUiState {
    object Success : SignUpScreenUiState
    object Error : SignUpScreenUiState
    object Loading : SignUpScreenUiState
}

class SignUpScreenViewModel (private val lotokRepository: LotokRepository) : ViewModel() {
    var signUpScreenUiState: SignUpScreenUiState by mutableStateOf(SignUpScreenUiState.Loading)
        private set

    var firstName: String by mutableStateOf("")
    var lastName: String by mutableStateOf("")
    var emailAddress: String by mutableStateOf("")
    var password: String by mutableStateOf("")
    var confirmPassword: String by mutableStateOf("")

    var errorMessage: String by mutableStateOf("")

    var openDialog: Boolean by mutableStateOf(false)

    fun resetErrorMessage() {
        errorMessage = ""
    }
    fun postSignUpInformation(){
        viewModelScope.launch {
            SignUpScreenUiState.Loading
            signUpScreenUiState = try {
                val signUpInformation = SignUp(
                    firstName,
                    lastName,
                    emailAddress,
                    password,
                    confirmPassword
                )
                lotokRepository.signUp(
                    signUpInformation
                )
                openDialog = true
                SignUpScreenUiState.Success
            } catch (e: IOException) {
                Log.e(e.message, "IOException")
                SignUpScreenUiState.Error
            } catch (e: HttpException) {
                val data = e.response()?.errorBody()?.string()
                data.let {
                    val json = JSONObject(data!!)
                    val keys = json.keys()
                    while(keys.hasNext()){
                        val key = keys.next()
                        val message = json.getString(key)
                        errorMessage = message
                        Log.e(e.message(), errorMessage)
                    }
                    SignUpScreenUiState.Error
                }
            }
        }

    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as LotokApplication)
                val marsPhotosRepository = application.container.lotokRepository
                SignUpScreenViewModel(lotokRepository = marsPhotosRepository)
            }
        }
    }
}