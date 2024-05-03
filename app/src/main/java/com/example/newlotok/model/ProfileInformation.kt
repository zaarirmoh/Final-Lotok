package com.example.newlotok.model

import androidx.annotation.DrawableRes
import com.example.newlotok.R

data class ProfileInformation(
    var name: String,
    @DrawableRes val picture: Int,
    var email: String,
    var carsPosted: Int,
    var postsSaved: Int,
    var bookings: Int,
    var firstName: String = "",
    var lastName: String = "",
    var location: String = "",
    var mobileNumber: String = "",
)

