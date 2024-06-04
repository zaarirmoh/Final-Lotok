package com.example.newlotok.ui.screens.profileScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newlotok.R
import com.example.newlotok.model.Data.profileInformation

@Composable
fun ProfilePictureAndName(
    modifier: Modifier = Modifier,
    secondTextComposable: @Composable () -> Unit = { ProfileSecondText() },
    profilePicture: String,
    profileName: String,
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current).data(profilePicture)
                .crossfade(true).build(),
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            contentDescription = null,
            modifier = modifier
                .size(96.dp)
                .clip(CircleShape)
        )
        /*
        Image(
            painter = painterResource(id = profileInformation.picture),
            contentDescription = null,
            modifier = modifier
                .size(96.dp)
                .clip(CircleShape)
        )
         */
        Spacer(modifier = modifier.height(8.dp))
        Text(
            text = profileName,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = modifier.height(4.dp))
        secondTextComposable()
    }
}
@Composable
fun ProfileSecondText(
    modifier: Modifier = Modifier,
    secondTextFontWeight: FontWeight = FontWeight.Normal,
    secondTextColor: Color = Color(0xFF7D848D),
    secondText: String = profileInformation.email,
){
    Text(
        text = secondText,
        fontSize = 14.sp,
        fontWeight = secondTextFontWeight,
        color = secondTextColor,
        modifier = modifier
    )
}