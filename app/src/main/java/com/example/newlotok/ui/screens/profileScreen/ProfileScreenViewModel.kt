package com.example.newlotok.ui.screens.profileScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import coil.decode.BitmapFactoryDecoder
import com.example.newlotok.LotokApplication
import com.example.newlotok.data.LotokRepository
import com.example.newlotok.model.ProfileInformation
import com.example.newlotok.ui.screens.homeScreen.HomeScreenViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface ProfileScreenUiState {
    data class Success(val profileInformation: ProfileInformation) : ProfileScreenUiState
    object Loading : ProfileScreenUiState
    object Error : ProfileScreenUiState
}

class ProfileScreenViewModel(private val lotokRepository: LotokRepository) : ViewModel() {
    var profileScreenUiState: ProfileScreenUiState by mutableStateOf(ProfileScreenUiState.Loading)
        private set

    /*
    init {
        getProfileInformation(authorization: String)
    }
     */

    fun getProfileInformation(authorization: String){
        viewModelScope.launch {
            profileScreenUiState = ProfileScreenUiState.Loading
            profileScreenUiState = try {
                ProfileScreenUiState.Success(lotokRepository.getProfileInformation(authorization))
            }catch (e: IOException){
                ProfileScreenUiState.Error
            }catch (e: HttpException){
                ProfileScreenUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as LotokApplication)
                val marsPhotosRepository = application.container.lotokRepository
                ProfileScreenViewModel(lotokRepository = marsPhotosRepository)
            }
        }
    }
}