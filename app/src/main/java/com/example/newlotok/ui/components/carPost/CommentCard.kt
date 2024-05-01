package com.example.newlotok.ui.components.carPost

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newlotok.R

@Composable
fun CommentCard(
    modifier: Modifier = Modifier,
    profilePic: Int,
    title: String,
    date: String,
    review: String,
    ) {
    Box(modifier = modifier.padding(bottom = 16.dp )) {
        Card(
            modifier = Modifier.padding(top = 24.dp,start = 10.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(8.dp),

        ) {
            Column(modifier = Modifier.padding(start = 16.dp, top = 25.dp,end = 16.dp,bottom = 16.dp )) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = title,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = date,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal ,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = review,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }

        Image(
            painter = painterResource(profilePic),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .align(Alignment.TopStart)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewReviewCard() {
    CommentCard(
        profilePic = R.drawable.profile_picture,
        title = "El Bench",
        date = "June 5, 2019",
        review = "good. but I prefer Atos.",
        
    )
}
