package com.example.newlotok.ui.screens.addPostScreen

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.newlotok.model.CarPostFirst
import com.example.newlotok.model.VinResult
import com.example.newlotok.ui.screens.bookingScreen.hostPictures
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddPostScreenViewModel {
    private val _uiState = MutableStateFlow(CarPostFirst())
    val uiState: StateFlow<CarPostFirst> = _uiState.asStateFlow()

    val vinResult : VinResult =  VinResult()
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
}