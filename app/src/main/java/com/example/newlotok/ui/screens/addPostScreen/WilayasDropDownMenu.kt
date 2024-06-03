package com.example.newlotok.ui.screens.addPostScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.toSize


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WilayasDropDownMenu(
    selectedWilaya: Int,
    onWilayaSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val wilayas = listOf(
        "Adrar", "Chlef", "Laghouat", "Oum El Bouaghi", "Batna", "Béjaïa",
        "Biskra", "Béchar", "Blida", "Bouira", "Tamanrasset", "Tébessa",
        "Tlemcen", "Tiaret", "Tizi Ouzou", "Algiers", "Djelfa", "Jijel",
        "Sétif", "Saïda", "Skikda", "Sidi Bel Abbès", "Annaba", "Guelma",
        "Constantine", "Médéa", "Mostaganem", "M'Sila", "Mascara", "Ouargla",
        "Oran", "El Bayadh", "Illizi", "Bordj Bou Arréridj", "Boumerdès",
        "El Tarf", "Tindouf", "Tissemsilt", "El Oued", "Khenchela", "Souk Ahras",
        "Tipaza", "Mila", "Aïn Defla", "Naâma", "Aïn Témouchent", "Ghardaïa",
        "Relizane"
    )

    var mTextFieldSize by remember { mutableStateOf(Size.Zero)}
    // Up Icon when expanded and down icon when collapsed
    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(modifier = modifier) {

        OutlinedTextField(
            value = wilayas[selectedWilaya],
            onValueChange = {  },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = {
                Text("Wilaya",color = Color(0xFF7D848D) )
                    },
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { expanded = !expanded })
            },
            readOnly = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor =  Color(0xFF7D848D)
            )


        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
        ) {
            wilayas.forEach { wilaya ->
                DropdownMenuItem(
                    text = { Text(text = wilaya, textAlign = TextAlign.Start) },
                    onClick = {
                        onWilayaSelected(wilayas.indexOf(wilaya) )
                        expanded = false
                    },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }
}