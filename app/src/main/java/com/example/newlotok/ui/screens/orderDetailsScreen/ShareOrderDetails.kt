package com.example.newlotok.ui.screens.orderDetailsScreen

import android.content.Context
import android.content.Intent
import com.example.newlotok.model.OrderDetails

fun shareOrderDetails(context: Context, order: OrderDetails) {
    val shareText = """
        Order Details:
        Car: ${order.carPost.make} ${order.carPost.model}
        Location: ${order.carPost.location}
        Client: ${order.firstName + " " + order.lastName}
        Phone: ${order.phoneNumber}
        Rental Period: ${order.fromDate} to ${order.toDate}
        Total Price: ${order.totalPrice} DZA
    """.trimIndent()

    val intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, shareText)
        type = "text/plain"
    }

    val shareIntent = Intent.createChooser(intent, null)
    context.startActivity(shareIntent)
}