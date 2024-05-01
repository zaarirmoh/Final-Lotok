package com.example.newlotok.ui.components.lines

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleLine(
    modifier: Modifier = Modifier,
    height : Int,
    startX : Int,
    endX : Int

    ) {
    Canvas(modifier = modifier
        .fillMaxWidth()
        .height(height.dp)) {
        drawLine(
            color = Color(0xD7,23,23),
            start = Offset(x = startX.dp.toPx(), y = 5f),
            end = Offset(x = endX.dp.toPx(), y = 5f),
            strokeWidth = 12f
        )
    }
}


@Composable
@Preview(showBackground = true)
fun SimpleLinePreview(){
    SimpleLine(height = 10, startX = 119, endX = 256 )
}