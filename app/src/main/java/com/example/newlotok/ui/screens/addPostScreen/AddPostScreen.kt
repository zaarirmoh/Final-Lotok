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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newlotok.ui.components.topBar.EndIconProfile
import com.example.newlotok.ui.components.topBar.StartIconGoBack
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.components.topBar.TopBarCenterText
import com.example.newlotok.ui.screens.bookingScreen.ImagePickerTextField


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPostScreen(
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
                .verticalScroll (rememberScrollState())
        ){
            ImagePickerTextField(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                "     Add the car's images",
                200
            )




            Text(
                text = "At least one image",
                color = Color.Red
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Add the car's papers", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))

            ImagePickerTextField(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 4.dp, top = 8.dp),
                "     Add the Carte Grise",
            )
            Spacer(modifier = Modifier.height(4.dp))
            ImagePickerTextField(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                "     Add the Assurance",

            )
            Spacer(modifier = Modifier.height(4.dp))

            ImagePickerTextField(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                "     Add the Technical Control",

            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Add the location", fontSize = 20.sp)
            BasicTextField(
                value = wilaya,
                onValueChange = { wilaya = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp),
                singleLine = true,
                decorationBox = { innerTextField ->
                    if (wilaya.isEmpty()) {
                        Text("Choose your Wilaya")
                    }
                    innerTextField()
                }
            )

            BasicTextField(
                value = address,
                onValueChange = { address = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp),
                singleLine = true,
                decorationBox = { innerTextField ->
                    if (address.isEmpty()) {
                        Text("Enter your Address")
                    }
                    innerTextField()
                }
            )

            Text("Add a description for your car:", fontSize = 20.sp)
            BasicTextField(
                value = description,
                onValueChange = { description = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.LightGray)
                    .padding(8.dp),
                decorationBox = { innerTextField ->
                    if (description.isEmpty()) {
                        Text("Label")
                    }
                    innerTextField()
                }
            )
        }

    }
}

@Composable
fun DocumentUploadButton(text: String) {
    Button(
        onClick = { /* Add document */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(vertical = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Add, contentDescription = "Add Document")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text)
        }
    }
}