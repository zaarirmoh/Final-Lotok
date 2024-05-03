package com.example.newlotok.ui.screens.carDetailsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newlotok.model.Data
import com.example.newlotok.ui.components.carPost.Rating

@Composable
fun ReviewSection(
    modifier: Modifier = Modifier,
    rating : Double,
    numberOfReviews : Int,
    description : String ?= null

) {

    Column(
        modifier = modifier

    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Rating(stars = rating)

            Spacer(modifier = Modifier.width(5.dp))

            // Display the number of reviews
            Text(
                text = "($numberOfReviews Reviews)",
                color = Color.LightGray,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(top = 6.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Display the review text

        if (description != null) {
            Text(
                text = description,
                modifier = Modifier.padding(top = 10.dp , start = 25.dp )
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ReviewSectionPreview() {
    ReviewSection(rating = 4.5,
        numberOfReviews = 23,
        description =  Data.carPostsList[0].description
    )
}