package com.example.newlotok.ui

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
import com.example.newlotok.ID
import com.example.newlotok.LotokApplication
import com.example.newlotok.REFRESH_TOKEN
import com.example.newlotok.data.LotokRepository
import com.example.newlotok.dataStore
import com.example.newlotok.model.AccessToken
import com.example.newlotok.model.CarPost
import com.example.newlotok.model.Tokens
import com.example.newlotok.ui.navigation.LotokScreen
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
sealed interface TokensUiState {
    object Success : TokensUiState
    object Loading : TokensUiState
    object Error : TokensUiState
}
sealed interface GetCarPostsUiState {
    data class Success(val carPosts: List<CarPost>) : GetCarPostsUiState
    object Loading : GetCarPostsUiState
    object Error : GetCarPostsUiState
}
class TokensViewModel(private val lotokRepository: LotokRepository) : ViewModel() {
    var tokensUiState: TokensUiState by mutableStateOf(TokensUiState.Loading)
    var getCarPostsUiState: GetCarPostsUiState by mutableStateOf(GetCarPostsUiState.Loading)
    var isAccessVerified: Boolean by mutableStateOf(false)
    var addPostRoute: String by mutableStateOf(LotokScreen.SignInScreen.name)
    // to be moved
    var carPost: CarPost? by mutableStateOf(null)
    var make: String? by mutableStateOf(null)
    var shouldSendUser: Boolean by mutableStateOf(true)
    fun verifyAccessToken(accessToken: AccessToken) {
        viewModelScope.launch {
            tokensUiState = try {
                lotokRepository.verifyToken(accessToken)
                isAccessVerified = true
                Log.d(null,"Access Verified")
                addPostRoute = LotokScreen.AddPostScreen.name
                TokensUiState.Success
            }catch(e: IOException){
                Log.e(null,"IOException")
                TokensUiState.Error
            }catch(e: HttpException){
                Log.e(null,"HttpException")
                TokensUiState.Error
            }
        }
    }
    suspend fun getRefreshToken(context: Context): String {
        val token = context.dataStore.data.first()
        return token[REFRESH_TOKEN] ?: ""
    }
    suspend fun setRefreshToken(token: String, context: Context) {
        context.dataStore.edit { settings ->
            settings[REFRESH_TOKEN] = token
        }
    }

    suspend fun getAccessToken(context: Context): String {
        val token = context.dataStore.data.first()
        return token[ACCESS_TOKEN] ?: ""

    }
    suspend fun setAccessToken(token: String, context: Context) {
        context.dataStore.edit { settings ->
            settings[ACCESS_TOKEN] = token
        }
    }
    suspend fun getID(context: Context): Int{
        val id = context.dataStore.data.first()
        return id[ID] ?: -1
    }

    fun getCarPosts(
        user: Int? = null,
        make: String? = null,
    ){
        viewModelScope.launch {
            getCarPostsUiState = GetCarPostsUiState.Loading
            getCarPostsUiState = try {
                GetCarPostsUiState.Success(lotokRepository.getCarPosts(
                    user = user,
                    make = make
                ))
            }catch (e: IOException){
                GetCarPostsUiState.Error
            }catch (e: HttpException){
                GetCarPostsUiState.Error
            }
        }

    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as LotokApplication)
                val marsPhotosRepository = application.container.lotokRepository
                TokensViewModel(lotokRepository = marsPhotosRepository)
            }
        }
    }
}