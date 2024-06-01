package com.example.newlotok.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.newlotok.LotokApplication
import com.example.newlotok.data.LotokRepository
import com.example.newlotok.model.CarPost
import com.example.newlotok.model.MarsPhoto
import kotlinx.coroutines.launch


class TryScreenViewModel(private val lotokRepository: LotokRepository) : ViewModel() {
    /** The mutable State that stores the status of the most recent request */




    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    init{
        addCarPost()
    }
    fun addCarPost() {
        viewModelScope.launch {
            try {
                lotokRepository.addCarPost(
                    carPost = CarPost(
                        id = 11,
                        model = "model",
                        year = 2000,
                        make = "make",
                        engine = "engine",
                        power = "150",
                        body = "body",
                        fuel = "fuel",
                        transmission = "transmission",
                        dayPrice = 1000,
                        weekPrice = 1500,
                        rating = 5.0,
                        description = "description",
                        location = "location",
                        imgSrc = "data:image/jpeg;base64,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"
                    )
                )
                Log.d(null,"success")
            }catch (e: Exception) {
                Log.e(null , "error")
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
                TryScreenViewModel(lotokRepository = marsPhotosRepository)
            }
        }
    }
}