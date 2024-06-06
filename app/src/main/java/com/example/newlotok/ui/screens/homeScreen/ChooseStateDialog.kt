package com.example.newlotok.ui.screens.homeScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.Calendar

@Composable
fun ChooseStateDialog(
    openDialog: MutableState<Boolean>,
    onStateSelected: (Int) -> Unit
){
    if(openDialog.value){
        AlertDialog(
            onDismissRequest = {},
            title = { Text(text = "Choose a Year") },
            text = {
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

                LazyColumn {
                    items(wilayas) { wilaya ->
                        Text(
                            text = wilaya,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .clickable {
                                    onStateSelected(wilayas.indexOf(wilaya)+1)
                                }
                        )
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = {openDialog.value = false}) {
                    Text("Cancel")
                }
            }
        )
    }
}