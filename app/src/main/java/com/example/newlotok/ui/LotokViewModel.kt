/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.newlotok.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.newlotok.LotokApplication
import com.example.newlotok.data.LotokRepository
import com.example.newlotok.model.CarPost
import com.example.newlotok.model.MarsPhoto
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

/**
 * UI state for the Home screen
 */
sealed interface LotokUiState {
    data class Success(val photos: List<CarPost>) : LotokUiState
    object Error : LotokUiState
    object Loading : LotokUiState
}

class LotokViewModel(private val lotokRepository: LotokRepository) : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var lotokUiState: LotokUiState by mutableStateOf(LotokUiState.Loading)
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
            lotokUiState = LotokUiState.Loading
            lotokUiState = try {
                LotokUiState.Success(lotokRepository.getCarPosts())
            } catch (e: IOException) {
                LotokUiState.Error
            } catch (e: HttpException) {
                LotokUiState.Error
            }
        }
    }

    /**
     * Factory for [LotokViewModel] that takes [LotokRepository] as a dependency
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as LotokApplication)
                val marsPhotosRepository = application.container.lotokRepository
                LotokViewModel(lotokRepository = marsPhotosRepository)
            }
        }
    }
}
