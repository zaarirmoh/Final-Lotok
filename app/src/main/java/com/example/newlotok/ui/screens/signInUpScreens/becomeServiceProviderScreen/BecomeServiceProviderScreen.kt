package com.example.newlotok.ui.screens.signInUpScreens.becomeServiceProviderScreen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newlotok.ui.components.topBar.StartIconGoBack
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.screens.bookingScreen.ImagePickerTextField
import com.example.newlotok.ui.screens.signInUpScreens.signInUpComponents.SignInUpButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BecomeServiceProviderScreen(
    modifier: Modifier = Modifier,
    onGoBackButtonClicked: () -> Unit,
    becomeServiceProviderViewModel: BecomeServiceProviderViewModel,
    onBecomeServiceProviderButtonClicked: () -> Unit
){
    val idImages = remember { mutableStateOf(becomeServiceProviderViewModel.idImages) }
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconGoBack(onButtonClicked = onGoBackButtonClicked) }
            )
        },
    ) {
        Column(modifier = modifier.padding(it)) {
            Text(
                text = "Add your id images :",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 30.dp)
            )
            ImagePickerTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 4.dp, top = 16.dp),
                "     Add the Carte Grise",
                selectedImageUris = idImages,
            )
            Spacer(modifier = modifier.height(30.dp))
            SignInUpButton(
                text = "Become Service Provider",
                onSignInButtonClicked = {
                    becomeServiceProviderViewModel.idImages = idImages.value
                    if(becomeServiceProviderViewModel.idImages.size == 2){
                        onBecomeServiceProviderButtonClicked()
                    }else{
                        Toast.makeText(context, "enter two images", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
    }
}