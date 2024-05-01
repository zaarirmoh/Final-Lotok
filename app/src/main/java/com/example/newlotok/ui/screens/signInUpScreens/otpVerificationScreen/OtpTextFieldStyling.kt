package com.example.lotok.ui.screens.signInUpScreens.otpVerificationScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OtpTextFieldStyling(
    modifier: Modifier = Modifier,
    length: Int,
    onFilled: (code: String) -> Unit = {},
    otpLength: Int = 4,
    otpText: String
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        repeat(otpLength) { index ->
            CharacterCell(
                index = index,
                text = otpText
            )
            if (index < otpLength-1) Spacer(modifier = Modifier.width(18.dp))
        }
    }
}
@Composable
internal fun CharacterCell(
    index: Int,
    text: String,
    shouldShowCursor: Boolean = false,
    shouldCursorBlink: Boolean = false,
) {
    val isFocused = text.length == index
    val character = when {
        index < text.length -> text[index].toString()
        else -> ""
    }
    Box(
        modifier = Modifier
            .size(height = 56.dp, width = 70.dp)
            .background(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFFDADADA)
            ),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = character,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}