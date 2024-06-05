package com.example.newlotok.ui.screens.addPostScreen

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.newlotok.ID
import com.example.newlotok.LotokApplication
import com.example.newlotok.data.LotokRepository
import com.example.newlotok.dataStore
import com.example.newlotok.model.CarPost
import com.example.newlotok.model.CarPostFirst
import com.example.newlotok.model.VinResult
import com.example.newlotok.ui.screens.bookingScreen.hostPictures
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface AddPostScreenUiState {
    data class Success(val data: CarPost) : AddPostScreenUiState
    object Loading : AddPostScreenUiState
    object Error : AddPostScreenUiState
}
class AddPostScreenViewModel(private val lotokRepository: LotokRepository) : ViewModel() {
    var addPostScreenUiState: AddPostScreenUiState by mutableStateOf(AddPostScreenUiState.Loading)
    private val _uiState = MutableStateFlow(CarPostFirst())
    val uiState: StateFlow<CarPostFirst> = _uiState.asStateFlow()
    val vinResult : VinResult =  VinResult()

    //var vin: String by mutableStateOf("")
    fun updateVin(vin: String) {
        updateItem(vin, "vin")
    }

    fun updateWilaya(wilaya: Int) {
        updateItem(wilaya.toString(), "wilaya")
    }

    fun updateAddress(address: String) {
        updateItem(address, "address")
    }

    fun updateDescription(description: String) {
        updateItem(description, "description")
    }

    fun updateDailyPrice(price: String) {
        updateItem(price, "dailyPrice")
    }

    fun updateWeeklyPrice(price: String) {
        updateItem(price, "weeklyPrice")
    }

    fun updateCarPictures(newCarPictures: List<Uri>) {
        val newCarPicturesUrls : MutableState<List<Uri>> = mutableStateOf(listOf())

        hostPictures(
            picturesUrl = newCarPicturesUrls,
            picturesUri = newCarPictures,
            onSuccess = { urls ->
                _uiState.value = _uiState.value.copy(carPictures = urls)

            },
            onFailure = { exception ->
                Log.e("Firebase", "Failed to upload images: ${exception.message}")
            }
        )


    }

    fun updateCarteGrisePic(newCarteGrisePic:List<Uri>) {
        val newCarteGrisePicUrls : MutableState<List<Uri>> = mutableStateOf(listOf())
        hostPictures(
            picturesUrl = newCarteGrisePicUrls,
            picturesUri = newCarteGrisePic,
            onSuccess = { urls ->
                _uiState.value = _uiState.value.copy(carteGrisePic = urls)

            },
            onFailure = { exception ->
                Log.e("Firebase", "Failed to upload images: ${exception.message}")
            }
        )
    }

    fun updateAssurancePic(newAssurancePic: List<Uri>) {
        val newAssurancePicUrls : MutableState<List<Uri>> = mutableStateOf(listOf())
        hostPictures(
            picturesUrl = newAssurancePicUrls,
            picturesUri = newAssurancePic,
            onSuccess = { urls ->
                _uiState.value = _uiState.value.copy(assurancePic = urls)

            },
            onFailure = { exception ->
                Log.e("Firebase", "Failed to upload images: ${exception.message}")
            }
        )
    }

    fun updateTechnicalControlPic(newTechnicalControlPic: List<Uri>) {
        val newTechnicalControlPicUrls : MutableState<List<Uri>> = mutableStateOf(listOf())
        hostPictures(
            picturesUrl = newTechnicalControlPicUrls,
            picturesUri = newTechnicalControlPic,
            onSuccess = { urls ->
                _uiState.value = _uiState.value.copy(technicalControlPic = urls)

            },
            onFailure = { exception ->
                Log.e("Firebase", "Failed to upload images: ${exception.message}")
            }
        )
    }

    private fun updateItem(newItem: String, type: String) {
        _uiState.update { currentState ->
            currentState.copy(
                vin = if (type == "vin") newItem else currentState.vin,
                wilaya = if (type == "wilaya") newItem.toInt() else currentState.wilaya,
                address = if (type == "address") newItem else currentState.address,
                description = if (type == "description") newItem else currentState.description,
                dailyPrice = if (type == "dailyPrice") newItem.toDouble() else currentState.dailyPrice,
                weeklyPrice = if (type == "weeklyPrice") newItem.toDouble() else currentState.weeklyPrice,
            )
        }
    }

    fun addCarPost(carPost: CarPost, authorization: String){
        viewModelScope.launch {
            addPostScreenUiState = AddPostScreenUiState.Loading
            addPostScreenUiState = try {
                AddPostScreenUiState.Success(
                    lotokRepository.addCarPost(authorization,carPost)
                )
            }catch (e: IOException){
                AddPostScreenUiState.Error
            }
            /*
            catch (e: HttpException){
                AddPostScreenUiState.Error
            }
             */
        }
    }

    suspend fun getID(context: Context): Int{
        val id = context.dataStore.data.first()
        return id[ID] ?: -1
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as LotokApplication)
                val marsPhotosRepository = application.container.lotokRepository
                AddPostScreenViewModel(lotokRepository = marsPhotosRepository)
            }
        }
    }
}