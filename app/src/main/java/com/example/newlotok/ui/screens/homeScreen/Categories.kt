package com.example.newlotok.ui.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lotok.ui.theme.Shapes
import com.example.newlotok.R
import com.example.newlotok.model.Data

@Composable
fun Categories(
    modifier: Modifier = Modifier
){
    Column {
        Text(
            text = stringResource(id = R.string.Categories),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            modifier = modifier.padding(start = 21.dp)
        )
        Spacer(modifier = modifier.height(11.dp))
        LazyRow {
            items(Data.categoriesList){
                Spacer(modifier = modifier.width(30.dp))
                CategoryCard(categoryPhoto = it.imgSrc)
            }
        }
    }
}
@Composable
fun CategoryCard(
    modifier: Modifier = Modifier,
    categoryPhoto: String,
){
    Button(
        onClick = { /*TODO*/ },
        shape = Shapes.small,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        //colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFBEBEA)),
        modifier = modifier.size(115.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current).data(categoryPhoto)
                .crossfade(true).build(),
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            contentDescription = null,
            modifier = modifier.fillMaxSize()
        )
    }
}