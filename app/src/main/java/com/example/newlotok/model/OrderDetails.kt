package com.example.newlotok.model

data class OrderDetails(
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val licenceNumber: String = "",
    val expirationDate: String = "dd/mm/yyyy",
    val fromDate: String = "dd/mm/yyyy",
    val toDate: String = "dd/mm/yyyy",
    val carPost: CarPost = Data.carPostsList[0],
    val paymentMethod: String = "Credit Card",
    val totalPrice : Double = 0.0
)
