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
import com.example.newlotok.LotokApplication
import com.example.newlotok.REFRESH_TOKEN
import com.example.newlotok.data.LotokRepository
import com.example.newlotok.dataStore
import com.example.newlotok.model.Tokens
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class TokensViewModel(private val lotokRepository: LotokRepository) : ViewModel() {

    var isAccessVerified: Boolean by mutableStateOf(false)
    fun verifyAccessToken(token: Tokens) {
        viewModelScope.launch {
            try {
                lotokRepository.verifyToken(token)
                isAccessVerified = true
                Log.d(null,"Access Verified")
            }catch(e: IOException){
                Log.e(null,"IOException")
            }catch(e: HttpException){
                Log.e(null,"HttpException")
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