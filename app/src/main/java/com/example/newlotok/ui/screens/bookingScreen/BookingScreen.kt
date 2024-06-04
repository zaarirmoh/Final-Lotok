package com.example.newlotok.ui.screens.bookingScreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newlotok.model.CarPost
import com.example.newlotok.model.Data
import com.example.newlotok.ui.components.carPost.Rating
import com.example.newlotok.ui.components.lines.SimpleLine
import com.example.newlotok.ui.components.topBar.EndIconProfile
import com.example.newlotok.ui.components.topBar.StartIconGoBack
import com.example.newlotok.ui.components.topBar.TopBar
import com.example.newlotok.ui.components.topBar.TopBarCenterText
import com.example.newlotok.ui.screens.carDetailsScreen.CarPictures
import com.example.newlotok.ui.screens.carDetailsScreen.ClickableText
import com.example.newlotok.ui.screens.carDetailsScreen.NameAndPrice


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("StateFlowValueCalledInComposition", "UnrememberedMutableState")
@Composable
fun BookingScreen(
    bookingSharedViewModel: BookingSharedViewModel,
    carPost : CarPost,
    onGoBackIconClicked: () -> Unit = {},
    bookNowButtonClicked : () -> Unit = {},
) {
    var firstName by remember {
        mutableStateOf(bookingSharedViewModel.uiState.value.firstName)
    }

    var lastName by remember {
        mutableStateOf(bookingSharedViewModel.uiState.value.lastName)
    }

    var phoneNumber by remember {
        mutableStateOf(bookingSharedViewModel.uiState.value.phoneNumber)
    }

    var licenceNumber by remember {
        mutableStateOf(bookingSharedViewModel.uiState.value.licenceNumber)
    }

    var fromDate by remember {
        mutableStateOf(bookingSharedViewModel.uiState.value.fromDate)
    }

    var toDate by remember {
        mutableStateOf(bookingSharedViewModel.uiState.value.toDate)
    }

    var expirationDate by remember {
        mutableStateOf(bookingSharedViewModel.uiState.value.expirationDate)
    }

    var paymentMethod by remember {
        mutableStateOf(bookingSharedViewModel.uiState.value.paymentMethod)
    }

    var DrivingLicencePics = mutableStateOf(bookingSharedViewModel.uiState.value.licensePics)


    val rentedDays = DateDifference(firstDate = fromDate, secondDate = toDate)

    val totalPrice = rentedDays * carPost.dayPrice

    val validCommand = (
            firstName.isNotEmpty() &&
                    lastName.isNotEmpty() &&
                    ( phoneNumber.length) == 10 && (phoneNumber.substring(0,2) == "05" || phoneNumber.substring(0,2) == "06" || phoneNumber.substring(0,2) == "07")
                    && phoneNumber.toIntOrNull() != null &&
                    licenceNumber.isNotEmpty() &&
                    fromDate != "dd/mm/yyyy" && toDate != "dd/mm/yyyy" &&
                    expirationDate != "dd/mm/yyyy"
            )
    var openDialog by remember { mutableStateOf(false)}

    var requeredFields by remember { mutableStateOf(false) }
    Log.d(null, "correct until here 2")
    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconGoBack(onButtonClicked = onGoBackIconClicked) },
                topBarCenter = { TopBarCenterText(text = "Booking") },
                endIcon = { EndIconProfile() }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            Box(modifier = Modifier.fillMaxWidth()){
                CarPictures(
                    imgSrc = carPost.fakeImgSrc,
                    modifier = Modifier.fillMaxWidth(),
                    buttonEnabled = false,
                )
                Rating(stars = carPost.rating)
            }
            Log.d(null, "correct until here 3")
            NameAndPrice(
                modifier = Modifier.padding(start = 11.dp , end = 11.dp ),
                name = carPost.model,
                mark = carPost.make,
                dayPrice = carPost.dayPrice,
                weekPrice = carPost.weekPrice
            )

            Text(
                text = "Client Informations :",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 30.dp)
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 8.dp, top = 16.dp),
                value = firstName,
                onValueChange = {it -> firstName = it} ,


                labelText ="First name",
                labelTextWarning ="Please enter your first name" ,
                placeHolderText = "",
                imageVector = Icons.Default.AccountBox,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                ),
                condition = {it.isNotEmpty()}

            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 8.dp, top = 8.dp),
                value = lastName,
                onValueChange = {it -> lastName = it},
                labelText ="Last name",
                labelTextWarning ="Please enter your last name" ,
                placeHolderText = "",
                imageVector = Icons.Default.Person,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                ),
                condition = {it.isNotEmpty()},

            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 16.dp, top = 8.dp),
                value = phoneNumber,
                onValueChange = {it -> phoneNumber = it},
                labelText = "Phone number",
                labelTextWarning = "Please enter a valid phone number",
                placeHolderText = "",
                imageVector = Icons.Default.Phone,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Phone
                ),
                condition = {it ->
                    ( it.length) == 10 && (it.substring(0,2) == "05" || it.substring(0,2) == "06" || it.substring(0,2) == "07")
                            && it.toIntOrNull() != null
                },


            )

            SimpleLine(
                height = 10,
                startX = 119,
                endX = 256,
                modifier = Modifier.padding(top=25.dp)
            )

            Text(
                text = "Driving Licence Inforamations :",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 25.dp)
            )
            Log.d(null, "correct until here 4")
            ImagePickerTextField(
                modifier= Modifier
                    .padding(start = 24.dp, end = 16.dp, bottom = 8.dp, top = 16.dp),
                selectedImageUris = DrivingLicencePics,
            )
            Log.d(null, "correct until here 0")
            Text(
                text = "Expiration Date :",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 24.dp, top = 20.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DatePickerButton(
                    date = expirationDate,
                    onDateChanged = {it -> expirationDate = it},
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                        .align(alignment = Alignment.Bottom))
                TextField(
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp)
                        .padding(start = 8.dp),
                    value = licenceNumber,
                    onValueChange = {it -> licenceNumber = it},
                    labelText = "number",
                    labelTextWarning = "Please enter your licence number",
                    placeHolderText = "",
                    imageVector = Icons.Default.CreditCard,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Phone
                    ),
                    condition = { it.isNotEmpty() }

                )
            }

            SimpleLine(
                height = 10,
                startX = 119,
                endX = 256,
                modifier = Modifier.padding(top=25.dp)
            )

            Text(
                text = "Booking informations :",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 25.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 24.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "From :",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .weight(1f)
                )
                Text(
                    text = "  To :",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .weight(1f)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp, start = 24.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DatePickerButton(
                    date = fromDate,
                    onDateChanged = {it -> fromDate = it},
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                        .align(alignment = Alignment.Bottom)
                )

                DatePickerButton(
                    date = toDate,
                    onDateChanged = {it -> toDate = it},
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                        .align(alignment = Alignment.Bottom)
                )
            }
            ClickableText(
                text = "Check availability here ? " ,
                onClick = {  },
                modifier = Modifier.padding(start = 34.dp )
            )

            Text(
                text = "Payment Method :",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 30.dp, top = 30.dp)
            )
            PaymentOptions(paymentMethod = {it -> paymentMethod = it})
            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 24.dp, end = 10.dp, bottom = 16.dp,top = 40.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total Price :",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = "${totalPrice} DZA",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(android.graphics.Color.parseColor("#B3261E"))
                )
            }


            Button(
                onClick = {
                        if (validCommand) openDialog = true else requeredFields = true
                          },
                colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#B3261E"))),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 16.dp, top = 16.dp )
            ) {
                Text(
                    text = "Book now",
                    fontSize = 18.sp ,
                    color = Color.White   ,
                    fontWeight = FontWeight.Bold,
                    modifier= Modifier.align(alignment = Alignment.CenterVertically)
                )
            }
            if (requeredFields)
                Text(
                text = "Please fill all the fields !",
                color = Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 16.dp, bottom = 16.dp),
                fontSize = 12.sp,
            )
            else Spacer(modifier = Modifier.height(30.dp))

            if (openDialog) {
                AlertDialog(
                    onDismissRequest = { openDialog = false  },
                    title = { Text("Confirm Booking") },
                    text = { Text("Are you sure you want to confirm this booking?") },
                    confirmButton = {
                        Button(onClick = {

                            bookNowButtonClicked()
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

            bookingSharedViewModel.updateFirstName(firstName)
            bookingSharedViewModel.updateLastName(lastName)
            bookingSharedViewModel.updatePhoneNumber(phoneNumber)
            bookingSharedViewModel.updateLicenceNumber(licenceNumber)
            bookingSharedViewModel.updateFromDate(fromDate)
            bookingSharedViewModel.updateToDate(toDate)
            bookingSharedViewModel.updateExpirationDate(expirationDate)
            bookingSharedViewModel.updatePaymentMethod(paymentMethod)
            bookingSharedViewModel.updateTotalPrice(totalPrice.toDouble())
            bookingSharedViewModel.updateLicensePics(DrivingLicencePics.value)



        }
    }
}





/*
@Composable
@Preview(showBackground = true)
fun BookingScreenPreview(){
    BookingScreen(carPost = Data.carPostsList[0],bookingSharedViewModel = bookingSharedViewModel)
}
 */