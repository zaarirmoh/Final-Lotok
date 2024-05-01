package com.example.lotok.ui.screens.selectBrandScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newlotok.model.CarBrand
import com.example.newlotok.model.Data
import com.example.newlotok.ui.components.topBar.EndIconProfile
import com.example.newlotok.ui.components.topBar.StartIconGoBack
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.components.topBar.TopBarCenterText
import com.example.lotok.ui.theme.LotokTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SelectBrandScreen(
    carBrandsList: List<CarBrand>,
    onGoBackIconClicked: () -> Unit = {},
    onLogoClicked: () -> Unit = {}
){
    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconGoBack(onButtonClicked = onGoBackIconClicked) }, //StartIconMenu()
                topBarCenter = { TopBarCenterText(text = "Choose a brand") },   //TopBarCenterText(text = "Home")
                endIcon = { EndIconProfile() }
            )
        }
    ) {
        LazyVerticalGrid (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp),
            columns = GridCells.Adaptive(150.dp),
            contentPadding = it,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items(items = carBrandsList){ carBrand -> BrandCard(
                brandPic = carBrand.brandPic,
                onClicked = onLogoClicked ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(13.dp)
                    .aspectRatio(1f)
            )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrandCard(
    brandPic : Int ,
    onClicked : () -> Unit,
    modifier: Modifier,
){

    Card(         onClick =  onClicked ,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(13.dp),
        modifier = modifier,

        ){
        Image(
            painter = painterResource(brandPic),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
@Preview
fun BrandCardPreview(){
    BrandCard(
        Data.carBrandsList[1].brandPic,
        {},
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.5f))
}
@Composable
@Preview
fun SelectBrandScreenPreview(){
    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        LotokTheme {
            SelectBrandScreen(
                Data.carBrandsList,
                onGoBackIconClicked = {}
            )
        }
    }
}