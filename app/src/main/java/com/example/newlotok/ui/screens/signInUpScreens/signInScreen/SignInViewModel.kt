package com.example.newlotok.ui.screens.signInUpScreens.signInScreen

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
import com.example.newlotok.model.CarPost
import com.example.newlotok.model.Category
import com.example.newlotok.model.MarsPhoto
import com.example.newlotok.ui.screens.homeScreen.HomeScreenUiState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface SignInScreenUiState {
    data class Success(
        val carPosts: List<CarPost>,
        val categories: List<Category>
    ) : SignInScreenUiState
    object Error : SignInScreenUiState
    object Loading : SignInScreenUiState
}

class HomeScreenViewModel(private val lotokRepository: LotokRepository) : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var homeScreenUiState: HomeScreenUiState by mutableStateOf(HomeScreenUiState.Loading)
        private set

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getCarPosts()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    fun getCarPosts() {
        viewModelScope.launch {
            homeScreenUiState = HomeScreenUiState.Loading
            homeScreenUiState = try {
                HomeScreenUiState.Success(
                    lotokRepository.getCarPosts(),
                    lotokRepository.getCategories()
                )
            } catch (e: IOException) {
                HomeScreenUiState.Error
            } catch (e: HttpException) {
                HomeScreenUiState.Error
            }
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
                HomeScreenViewModel(lotokRepository = marsPhotosRepository)
            }
        }
    }
}