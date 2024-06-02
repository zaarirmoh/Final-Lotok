package com.example.newlotok.ui.screens.addPostScreen

import com.example.newlotok.model.CarPostFirst
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddPostScreenViewModel {
    private val _uiState = MutableStateFlow(CarPostFirst())
    val uiState: StateFlow<CarPostFirst> = _uiState.asStateFlow()

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

    private fun updateItem(newItem: String, type: String) {
        _uiState.update { currentState ->
            currentState.copy(
                vin = if (type == "vin") newItem else currentState.vin,
                wilaya = if (type == "wilaya") newItem.toInt() else currentState.wilaya,
                address = if (type == "address") newItem else currentState.address,
                description = if (type == "description") newItem else currentState.description
            )
        }
    }
}