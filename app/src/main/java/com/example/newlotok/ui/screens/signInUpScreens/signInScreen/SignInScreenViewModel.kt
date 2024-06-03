package com.example.newlotok.ui.screens.signInUpScreens.signInScreen

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.newlotok.ACCESS_TOKEN
import com.example.newlotok.LotokApplication
import com.example.newlotok.REFRESH_TOKEN
import com.example.newlotok.data.LotokRepository
import com.example.newlotok.dataStore
import com.example.newlotok.model.SignIn
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.json.JSONObject
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
    var errorMessage: String by mutableStateOf("")
        private set

    var shouldNavigateToHomeScreen: Boolean by mutableStateOf(false)
        private set
    private var refreshToken: String by mutableStateOf("")

    private var accessToken: String by mutableStateOf("")
    fun postSignInInformation() {
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
                accessToken = tokens.accessToken
                refreshToken = tokens.refreshToken
                // to be removed
                Log.d(null, tokens.accessToken)
                Log.d(null, tokens.refreshToken)
                shouldNavigateToHomeScreen = true
                SignInScreenUiState.Success(
                    refreshToken = tokens.refreshToken,
                    accessToken = tokens.accessToken
                )
            } catch (e: IOException){
                Log.d(null, "exception")
                SignInScreenUiState.Error
            } catch (e: HttpException){
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
                    SignInScreenUiState.Error
                }
            }
        }
    }

    suspend fun getRefreshToken(context: Context): String {
        val token = context.dataStore.data.first()
        return token[REFRESH_TOKEN] ?: ""
    }
    suspend fun setRefreshToken(context: Context) {
        context.dataStore.edit { settings ->
            settings[REFRESH_TOKEN] = refreshToken
        }
        Log.d("refreshToken", refreshToken)
    }
    suspend fun getAccessToken(context: Context): String {
        val token = context.dataStore.data.first()
        return token[ACCESS_TOKEN] ?: ""
    }
    suspend fun setAccessToken(context: Context) {
        context.dataStore.edit { settings ->
            settings[ACCESS_TOKEN] = accessToken
        }
        Log.d("accessToken", accessToken)
    }

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