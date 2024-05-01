package com.example.lotok.ui.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp


val Shapes = Shapes(
    small = RoundedCornerShape(16.dp),
    medium = RoundedCornerShape(bottomStart = 16.dp, topEnd = 16.dp),
    large = CutCornerShape(topStart = 0.dp)
)
val SignInUpCardShapes = Shapes(
    medium = RoundedCornerShape(24.dp),
    small = CircleShape
)