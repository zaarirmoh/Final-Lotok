package com.example.newlotok.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrderDetailsPost(
    @SerialName(value = "listing")
    val listing: Int,
    //val listing: Int = -1,
    @SerialName(value = "client_first_name")
    val firstName: String,

    @SerialName(value = "client_last_name")
    val lastName: String,

    @SerialName(value = "phone_number")
    val phoneNumber: Int,

    @SerialName(value = "start_date")
    val fromDate: String = "dd/mm/yyyy",

    @SerialName(value = "end_date")
    val toDate: String = "dd/mm/yyyy",

    @SerialName(value = "payment_method")
    val paymentMethod: String,

    @SerialName(value = "front_driving_license")
    val licensePicFront: String,

    @SerialName(value = "back_driving_license")
    val licensePicBack: String,

    @SerialName(value = "total_price")
    val totalPrice: Double,

    @SerialName(value = "client_email")
    val emailAddress: String,

    @SerialName(value = "pickup_time")
    val pickUpTime: String,
    /*
    @SerialName(value = "licence_number")
    val licenceNumber: String = "",
     */
)
