package com.example.newlotok.ui.screens.signInUpScreens.becomeServiceProviderScreen

import android.net.Uri
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
import com.example.newlotok.model.ServiceProviderId
import com.example.newlotok.ui.screens.homeScreen.HomeScreenViewModel
import kotlinx.coroutines.launch

class BecomeServiceProviderViewModel (private val lotokRepository: LotokRepository): ViewModel(){
    var idImages: List<Uri> by mutableStateOf(emptyList())

    fun becomeServiceProvider(authorization: String,serviceProviderId: ServiceProviderId){
        viewModelScope.launch {
            lotokRepository.becomeServiceProvider(authorization,serviceProviderId)
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as LotokApplication)
                val marsPhotosRepository = application.container.lotokRepository
                BecomeServiceProviderViewModel(lotokRepository = marsPhotosRepository)
            }
        }
    }
}