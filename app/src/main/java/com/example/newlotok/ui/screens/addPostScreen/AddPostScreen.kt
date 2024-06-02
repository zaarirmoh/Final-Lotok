package com.example.newlotok.ui.screens.addPostScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newlotok.ui.components.topBar.EndIconProfile
import com.example.newlotok.ui.components.topBar.StartIconGoBack
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.components.topBar.TopBarCenterText
import com.example.newlotok.ui.screens.bookingScreen.ImagePickerTextField
import com.example.newlotok.ui.screens.bookingScreen.TextField
import com.example.newlotok.ui.screens.bookingScreen.WilayasDropDownMenu


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPostScreen(
    addPostScreenViewModel: AddPostScreenViewModel,
    onGoBackIconClicked: () -> Unit,
    onPostClick: () -> Unit
){
    var wilaya by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconGoBack(onButtonClicked = onGoBackIconClicked) },
                topBarCenter = { TopBarCenterText(text = "Add a Car") },
                endIcon = { EndIconProfile() }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Add the car's images :",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 30.dp)
            )

            ImagePickerTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 4.dp),
                "     Add the car's images",
                260
            )

            Text(
                text = "At least one image",
                color = Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 4.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.End
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Add the car's papers :",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 30.dp)
            )

            ImagePickerTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 4.dp, top = 8.dp),
                "     Add the Carte Grise",
            )
            Spacer(modifier = Modifier.height(4.dp))
            ImagePickerTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                "     Add the Assurance",
            )
            Spacer(modifier = Modifier.height(4.dp))

            ImagePickerTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                "     Add the Technical Control",
            )

            Text(
                text = "Add car's location :",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 30.dp)
            )

            WilayasDropDownMenu(
                modifier = Modifier.padding(
                    start = 24.dp,
                    end = 16.dp,
                    bottom = 8.dp
                ),
                selectedWilaya = wilaya,
                onWilayaSelected = { wilaya = it }
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 8.dp, top = 16.dp),
                value = address,
                onValueChange = { address = it },
                labelText = "Your Address",
                labelTextWarning = "Please enter your address",
                placeHolderText = "",
                imageVector = Icons.Default.LocationOn,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                ),
                condition = { it.isNotEmpty() }
            )

            Text(
                text = "Add a description for your car: ",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 30.dp)
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 24.dp, top = 16.dp),
                value = description,
                onValueChange = { description = it },
                labelText = "Description",
                labelTextWarning = "",
                placeHolderText = "",
                imageVector = Icons.Default.Description,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                ),
                condition = { it.isNotEmpty() },
                shapeSize = 60,
                singleLine = false,
            )

            Button(
                onClick = onPostClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Post")
            }

            // Update ViewModel with latest values
            addPostScreenViewModel.updateWilaya(wilaya)
            addPostScreenViewModel.updateAddress(address)
            addPostScreenViewModel.updateDescription(description)
        }


        }
    }
}

