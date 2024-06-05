package com.example.newlotok.ui.screens.bookingScreen

import android.net.Uri
import android.util.Log
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
import com.example.newlotok.model.OrderDetails
import com.example.newlotok.model.OrderDetailsPost
import com.example.newlotok.ui.screens.addPostScreen.AddPostScreenViewModel
import com.example.newlotok.ui.screens.signInUpScreens.signInScreen.SignInScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.util.Locale

sealed interface BookingUIState{
    object Success : BookingUIState
    object Error : BookingUIState
    object Loading : BookingUIState
}
class BookingSharedViewModel(private val lotokRepository: LotokRepository) : ViewModel() {
    var bookingUIState: BookingUIState = BookingUIState.Loading
    private val _uiState = MutableStateFlow(OrderDetails())
    val uiState: StateFlow<OrderDetails> = _uiState.asStateFlow()
    var shouldNavigate by mutableStateOf(false)

    fun postBooking(orderDetails: OrderDetails){
        viewModelScope.launch {
            bookingUIState = BookingUIState.Loading
            bookingUIState = try {
                val orderDetailsPost: OrderDetailsPost = OrderDetailsPost(
                    listing = orderDetails.carPost.id,
                    firstName = orderDetails.firstName,
                    lastName = orderDetails.lastName,
                    phoneNumber = orderDetails.phoneNumber.toInt(),
                    fromDate = orderDetails.fromDate,
                    toDate = orderDetails.toDate,
                    paymentMethod = orderDetails.paymentMethod.toLowerCase(Locale.ROOT),
                    totalPrice = orderDetails.totalPrice,
                    emailAddress = orderDetails.emailAddress,
                    licensePicFront = "something Url",
                    licensePicBack = "something not Url",
                    pickUpTime = "13:00:30"
                )

                Log.d("order data", orderDetailsPost.toString())
                Log.d("order id",orderDetailsPost.listing.toString())
                lotokRepository.postBooking(orderDetailsPost)
                shouldNavigate = true
                Log.d("until here","until here")
                BookingUIState.Success
            }catch (e: IOException){
                BookingUIState.Error
            }catch(e: HttpException){
                Log.e("error", e.toString())
                val data = e.response()?.errorBody()?.string()
                Log.e("data", data.toString())
                data.let {
                    val json = JSONObject(data!!)
                    Log.e("json",json.toString())
                    val keys = json.keys()
                    while(keys.hasNext()){
                        val key = keys.next()
                        val message = json.getString(key)
                        Log.e(key, message)
                    }
                    SignInScreenUiState.Error
                }
                BookingUIState.Error
            }
            /*
            catch (e: HttpException){
                BookingUIState.Error
            }
             */
        }

    }

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

    fun updateCarPost(carPost: CarPost){
        _uiState.value = _uiState.value.copy(carPost = carPost)
    }
    fun updateEmailAddress(email: String){
        _uiState.value = _uiState.value.copy(emailAddress = email)
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
                totalPrice = if (type == "totalPrice") newItem.toDouble() else currentState.totalPrice,
            )
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as LotokApplication)
                val marsPhotosRepository = application.container.lotokRepository
                BookingSharedViewModel(lotokRepository = marsPhotosRepository)
            }
        }
    }


}