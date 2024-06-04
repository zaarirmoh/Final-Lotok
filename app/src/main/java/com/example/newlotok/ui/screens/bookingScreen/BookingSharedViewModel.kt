package com.example.newlotok.ui.screens.bookingScreen

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.example.newlotok.model.OrderDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BookingSharedViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(OrderDetails())
    val uiState: StateFlow<OrderDetails> = _uiState.asStateFlow()

    fun updateFirstName(name: String) {
        updateItem(name, "firstName")
    }

    fun updateLastName(name: String) {
        updateItem(name, "lastName")
    }

    fun updatePhoneNumber(phone: String) {
        updateItem(phone, "phoneNumber")
    }

    fun updateLicenceNumber(licence: String) {
        updateItem(licence, "licenceNumber")
    }

    fun updateFromDate(date: String) {
        updateItem(date, "fromDate")
    }

    fun updateToDate(date: String) {
        updateItem(date, "toDate")
    }

    fun updateExpirationDate(date: String) {
        updateItem(date, "expirationDate")
    }
    fun updatePaymentMethod(paymentMethod: String) {
        updateItem(paymentMethod, "paymentMethod")
    }

    fun updateTotalPrice(totalPrice: Double) {
        updateItem(totalPrice.toString(), "totalPrice")
    }

    fun updateLicensePics(licensePics: List<Uri>){
        _uiState.value = _uiState.value.copy(licensePics = licensePics)

    }



    private fun updateItem(newItem: String, type: String) {
        _uiState.update { currentState ->
            currentState.copy(
                firstName = if (type == "firstName") newItem else currentState.firstName,
                lastName = if (type == "lastName") newItem else currentState.lastName,
                phoneNumber = if (type == "phoneNumber") newItem else currentState.phoneNumber,
                licenceNumber = if (type == "licenceNumber") newItem else currentState.licenceNumber,
                fromDate = if (type == "fromDate") newItem else currentState.fromDate,
                toDate = if (type == "toDate") newItem else currentState.toDate,
                expirationDate = if (type == "expirationDate") newItem else currentState.expirationDate,
                paymentMethod = if (type == "paymentMethod") newItem else currentState.paymentMethod,
                totalPrice = if (type == "totalPrice") newItem.toDouble() else currentState.totalPrice

            )
        }
    }




}