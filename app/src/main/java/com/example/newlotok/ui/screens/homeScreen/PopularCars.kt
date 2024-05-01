package com.example.newlotok.ui.screens.homeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newlotok.R
import com.example.newlotok.model.CarPost
import com.example.newlotok.model.Data
import com.example.newlotok.ui.components.carPost.CarPostCard

@Composable
fun PopularCars(
    modifier: Modifier = Modifier
){
    Column{
        Text(
            text = stringResource(id = R.string.PopularCars),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            modifier = modifier.padding(start = 21.dp)
        )
        CarPosts()
    }
}
@Composable
fun CarPosts(
    modifier: Modifier = Modifier,
    posts: List<CarPost> = listOf()
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp),
        horizontalArrangement = Arrangement.spacedBy(13.dp),
        modifier = modifier.height((220*(Data.carPostsList.size/2)).dp)
    ) {
        items(posts){
            CarPostCard(carPostInfo = it)
        }
    }
}
