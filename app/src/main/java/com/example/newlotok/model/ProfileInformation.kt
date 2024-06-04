package com.example.newlotok.model

import androidx.annotation.DrawableRes
import com.example.newlotok.R
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileInformation(
    val id: Int,
    @SerialName(value = "first_name")
    var firstName: String = "",
    @SerialName(value = "last_name")
    var lastName: String = "",
    @SerialName(value = "image_url")
    val picture: String,
    var email: String,
    @SerialName(value = "is_verified")
    val isVerified: Boolean,
    @SerialName(value = "is_service_provider")
    val isServiceProvider: Boolean,
    @SerialName(value = "is_staff")
    val isStaff: Boolean,

    var carsPosted: Int = 200,
    var postsSaved: Int = 200,
    var bookings: Int = 200,
    var location: String = "",
    var mobileNumber: String = "",
    var name: String = "",
)

