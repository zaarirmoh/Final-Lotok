package com.example.newlotok.ui.screens.addPostScreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.DirectionsCarFilled
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PriceChange
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.newlotok.ui.components.topBar.EndIconProfile
import com.example.newlotok.ui.components.topBar.StartIconGoBack
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.components.topBar.TopBarCenterText
import com.example.newlotok.ui.screens.bookingScreen.ImagePickerTextField
import com.example.newlotok.ui.screens.bookingScreen.TextField
import kotlinx.coroutines.delay


//@SuppressLint("UnrememberedMutableState", "StateFlowValueCalledInComposition")
@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPostScreen(
    addPostScreenViewModel: AddPostScreenViewModel,
    onGoBackIconClicked: () -> Unit,
    onConfirmButtonClicked: () -> Unit,
    onAddPostButtonClicked: () -> Unit,
    onProfileIconClicked : ()-> Unit = {},
){
    var wilaya by remember { mutableStateOf(addPostScreenViewModel.uiState.value.wilaya) }
    var address by remember { mutableStateOf(addPostScreenViewModel.uiState.value.address) }
    var description by remember { mutableStateOf(addPostScreenViewModel.uiState.value.description) }
    var vin by remember { mutableStateOf(addPostScreenViewModel.uiState.value.vin) }
    var dailyPrice by remember { mutableStateOf("0.0") }
    var weeklyPrice by remember { mutableStateOf("0.0") }
    var carPictures = remember {mutableStateOf(addPostScreenViewModel.uiState.value.carPictures)}
    var carteGrisePic = remember {mutableStateOf(addPostScreenViewModel.uiState.value.carteGrisePic)}
    var assurancePic = remember {mutableStateOf(addPostScreenViewModel.uiState.value.assurancePic)}
    var technicalControlPic = remember {mutableStateOf(addPostScreenViewModel.uiState.value.technicalControlPic)}
    var make by remember { mutableStateOf(addPostScreenViewModel.uiState.value.make) }
    var model by remember { mutableStateOf(addPostScreenViewModel.uiState.value.model) }
    var body by remember { mutableStateOf(addPostScreenViewModel.uiState.value.body) }
    var fuel by remember { mutableStateOf(addPostScreenViewModel.uiState.value.fuel) }
    var year by remember { mutableStateOf(addPostScreenViewModel.uiState.value.year) }
    var power by remember { mutableStateOf(addPostScreenViewModel.uiState.value.power) }
    var engine by remember { mutableStateOf(addPostScreenViewModel.uiState.value.engine) }
    var count = remember {mutableStateOf(0)}
    val validPost= (
            address.isNotEmpty() &&
                    vin.isNotEmpty() && dailyPrice.isNotEmpty() && weeklyPrice.isNotEmpty()
                    && carPictures.value.isNotEmpty() && carteGrisePic.value.isNotEmpty() &&
                    assurancePic.value.isNotEmpty() && technicalControlPic.value.isNotEmpty()
            )

    var requeredFields by remember { mutableStateOf(false) }
    var openDialog by remember { mutableStateOf(false)}
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        Log.d("AddPostScreenId", addPostScreenViewModel.getID(context).toString())
    }
    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconGoBack(onButtonClicked = onGoBackIconClicked) },
                topBarCenter = { TopBarCenterText(text = "Add a Car") },
                endIcon = { EndIconProfile(onProfileIconClicked) }
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
                    .padding(start = 26.dp, end = 16.dp, top = 16.dp, bottom = 4.dp),
                "     Add the car's images",
                260,
                selectedImageUris = carPictures
            )

            Text(
                text = "At least one image",
                color = Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 4.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.End,
                fontSize = 12.sp,
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
                    .padding(start = 24.dp, end = 16.dp, bottom = 4.dp, top = 16.dp),
                "     Add the Carte Grise",
                selectedImageUris = carteGrisePic
            )
            Spacer(modifier = Modifier.height(4.dp))
            ImagePickerTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 4.dp),
                "     Add the Assurance",
                selectedImageUris = assurancePic
            )
            Spacer(modifier = Modifier.height(4.dp))

            ImagePickerTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 16.dp),
                "     Add the Technical Control",
                selectedImageUris = technicalControlPic
            )


            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 24.dp, top = 16.dp),
                value = vin,
                onValueChange = {
                    vin = it
                    addPostScreenViewModel.updateVin(vin)
                                },
                labelText = "Vehicle Identification Number",
                labelTextWarning = "",
                placeHolderText = "",
                imageVector = Icons.Default.DirectionsCarFilled,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                ),
                condition = {true},
                shapeSize = 60,
                singleLine = false,
            )



            Text(
                text = "Add car's location :",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 30.dp,bottom = 16.dp)
            )

            WilayasDropDownMenu(
                modifier = Modifier.padding(
                    start = 24.dp,
                    end = 16.dp,
                    bottom = 8.dp
                ),
                selectedWilaya = wilaya,
                onWilayaSelected = {
                    wilaya = it
                    addPostScreenViewModel.updateWilaya(wilaya)
                }
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 8.dp, top = 16.dp),
                value = address,
                onValueChange = {
                    address = it
                    addPostScreenViewModel.updateAddress(address) },
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
                onValueChange = {
                    description = it
                    addPostScreenViewModel.updateDescription(description)

                                },
                labelText = "Description",
                labelTextWarning = "",
                placeHolderText = "",
                imageVector = Icons.Default.Description,
                keyboardOptions = KeyboardOptions.Default,
                condition = {true},
                shapeSize = 61,
                singleLine = false,
            )
            // -------------------
            Text(
                text = "Enter your cars information: ",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 30.dp)
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 16.dp, top = 16.dp),
                value = make,
                onValueChange = {
                    make = it
                    addPostScreenViewModel.updateMake(make)

                                },
                labelText = "make",
                labelTextWarning = "",
                placeHolderText = "",
                imageVector = Icons.Default.Inventory,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                ),
                condition = {it.isNotEmpty() },
                shapeSize = 60,
                singleLine = true,
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 16.dp, top = 16.dp),
                value = model,
                onValueChange = {
                    model = it
                    addPostScreenViewModel.updateModel(model)
                                },
                labelText = "model",
                labelTextWarning = "",
                placeHolderText = "",
                imageVector = Icons.Default.Inventory,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                ),
                condition = {it.isNotEmpty() },
                shapeSize = 60,
                singleLine = true,
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 16.dp, top = 16.dp),
                value = engine,
                onValueChange = {
                    engine = it
                    addPostScreenViewModel.updateEngine(engine)
                                },
                labelText = "engine",
                labelTextWarning = "",
                placeHolderText = "",
                imageVector = Icons.Default.Inventory,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                ),
                condition = {it.isNotEmpty() },
                shapeSize = 60,
                singleLine = true,
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 16.dp, top = 16.dp),
                value = year.toString(),
                onValueChange = {
                    year = if(it.length > 0) it.toInt() else 0
                    addPostScreenViewModel.updateYear(year)
                                },
                labelText = "year",
                labelTextWarning = "",
                placeHolderText = "",
                imageVector = Icons.Default.Inventory,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Number
                ),
                condition = {it.isNotEmpty() },
                shapeSize = 60,
                singleLine = true,
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 16.dp, top = 16.dp),
                value = fuel,
                onValueChange = {
                    fuel = it
                    addPostScreenViewModel.updateFuel(fuel)

                                },
                labelText = "fuel",
                labelTextWarning = "",
                placeHolderText = "",
                imageVector = Icons.Default.Inventory,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                ),
                condition = {it.isNotEmpty() },
                shapeSize = 60,
                singleLine = true,
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 16.dp, top = 16.dp),
                value = body,
                onValueChange = {
                    body = it
                    addPostScreenViewModel.updateBody(body)
                                },
                labelText = "body",
                labelTextWarning = "",
                placeHolderText = "",
                imageVector = Icons.Default.Inventory,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                ),
                condition = {it.isNotEmpty() },
                shapeSize = 60,
                singleLine = true,
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 16.dp, top = 16.dp),
                value = power.toString(),
                onValueChange = {
                    power = if(it.length > 0) it.toInt() else 0
                    addPostScreenViewModel.updatePower(power)
                                },
                labelText = "power",
                labelTextWarning = "",
                placeHolderText = "",
                imageVector = Icons.Default.Inventory,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Number
                ),
                condition = { it.isNotEmpty() },
                shapeSize = 60,
                singleLine = true,
            )
            // end here -------------------
            Text(
                text = "Add a price for your car: ",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 30.dp)
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 16.dp, top = 16.dp),
                value = dailyPrice,
                onValueChange = { dailyPrice = it },
                labelText = "dailyPrice DZA/day",
                labelTextWarning = "",
                placeHolderText = "",
                imageVector = Icons.Default.PriceChange,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Number
                ),
                condition = { it.isNotEmpty() },
                shapeSize = 60,
                singleLine = true,
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 24.dp),
                value = weeklyPrice,
                onValueChange = { weeklyPrice = it },
                labelText = "weeklyPrice DZA/week",
                labelTextWarning = "",
                placeHolderText = "",
                imageVector = Icons.Default.PriceChange,

                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Number
                ),
                condition = { it.isNotEmpty() },
                shapeSize = 60,
                singleLine = true,
            )



            Button(
                onClick = {

                    if (!validPost)  requeredFields = true else openDialog = true
                    onAddPostButtonClicked()
                },
                colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#B3261E"))),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 16.dp, top = 16.dp)
            ) {
                Text(
                    text = "Add Post",
                    fontSize = 18.sp ,
                    color = Color.White   ,
                    fontWeight = FontWeight.Bold,
                    modifier= Modifier.align(alignment = Alignment.CenterVertically)
                )
            }

            if (requeredFields ){
                Text(
                        text = "Please fill all the required fields !",
                        color = Color.Red,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp, end = 16.dp, bottom = 16.dp),
                        fontSize = 12.sp,
                    )
            }
            else Spacer(modifier = Modifier.height(30.dp))




            // Update ViewModel with latest values


            addPostScreenViewModel.updateCarPictures(carPictures.value,count = count)
            if (dailyPrice.isNotEmpty() && weeklyPrice.isNotEmpty()) {
                addPostScreenViewModel.updateDailyPrice(dailyPrice)
                addPostScreenViewModel.updateWeeklyPrice(weeklyPrice)
            }



            if (openDialog) {
                AlertDialog(
                    onDismissRequest = { openDialog = false},
                    title = { Text("Confirm Car Details") },
                    text = { VinDetails(modifier = Modifier,addPostScreenViewModel.vinResult)
                        AsyncImage(
                            model = addPostScreenViewModel.uiState.value.carPictures[0] ,
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                                .padding(4.dp),
                            contentScale = ContentScale.Crop
                        )
                           },
                    confirmButton = {
                        Button(onClick = {
                            addPostScreenViewModel.updateCarPictures(carPictures.value,count)
                            addPostScreenViewModel.updateCarteGrisePic(carteGrisePic.value)
                            addPostScreenViewModel.updateAssurancePic(assurancePic.value)
                            addPostScreenViewModel.updateTechnicalControlPic(technicalControlPic.value)
                            onConfirmButtonClicked()
                            openDialog = false
                        }) {
                            Text("Confirm")
                        }
                    },
                    dismissButton = {
                        Button(onClick = { openDialog = false }) {
                            Text("Cancel")
                        }
                    }
                )
            }
        }
    }
}



