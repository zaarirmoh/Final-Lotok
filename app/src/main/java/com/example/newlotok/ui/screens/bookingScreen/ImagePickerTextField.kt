package com.example.newlotok.ui.screens.bookingScreen

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import coil.compose.AsyncImage
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Objects

@Composable
fun ImagePickerTextField(
    modifier: Modifier,
    text : String = "    Driving licence Pictures",
    shapeSize : Int = 80,
    imageSize : Int = 80,
) {
    Log.d(null, "correct until here 5")
    val context = LocalContext.current
    val file = context.createImageFile()
    Log.d(null, "correct until here 6")
    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        context.packageName + ".provider", file
    )
    Log.d(null, "correct until here 7")
    var capturedImageUri by remember {
        mutableStateOf<Uri>(Uri.EMPTY)
    }
    Log.d(null, "correct until here 8")
    var selectedImageUris by remember {
        mutableStateOf<List<Uri>>(emptyList())
    }

    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()){
            capturedImageUri = uri
            selectedImageUris = selectedImageUris.toMutableList().apply { add(capturedImageUri) }
        }


    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){
        if (it)
        {
            Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
            cameraLauncher.launch(uri)
        }
        else
        {
            Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    var isDialogOpen by remember { mutableStateOf(false) }


    val multiplePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(),
        onResult = { uris -> selectedImageUris = uris }
    )
    Log.d(null, "correct until here ")
    Card(
        modifier = modifier.fillMaxWidth().height(shapeSize.dp).clickable { isDialogOpen = true },
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, Color.Gray),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Row(modifier = Modifier.fillMaxSize(),horizontalArrangement = Arrangement.SpaceBetween) {
            if (selectedImageUris.isEmpty()) {
                Text(
                    text = text,
                    color = Color.Gray,
                    modifier = Modifier.align(
                        Alignment.CenterVertically
                    )

                )

            }
            else  {
                var firstIndex = 0
                val chunkSize = 4

                Column(modifier = Modifier.fillMaxWidth()) {
                    while (firstIndex < selectedImageUris.size) {
                        val lastIndex = (firstIndex + chunkSize).coerceAtMost(selectedImageUris.size)
                        val imageUris = selectedImageUris.subList(firstIndex, lastIndex)
                        Row(modifier = Modifier.fillMaxWidth()) {
                            imageUris.forEach { uri ->
                                AsyncImage(
                                    model = uri,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(imageSize.dp)
                                        .padding(4.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                        }
                        firstIndex += chunkSize
                    }
                }
            }

            IconButton(onClick = { isDialogOpen = true }, modifier = Modifier.align(alignment = Alignment.CenterVertically)) {
                Icon(Icons.Default.Upload, contentDescription = null)
            }

        }
    }

    if (isDialogOpen) {
        AlertDialog(
            onDismissRequest = { isDialogOpen = false },
            title = { Text("Choose an image") },
            text = {
                Column {
                    TextButton(onClick = {
                        val permissionCheckResult =
                            ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
                        if (permissionCheckResult == PackageManager.PERMISSION_GRANTED)
                        {
                            cameraLauncher.launch(uri)
                            capturedImageUri = uri
                            selectedImageUris.toMutableList().add(capturedImageUri)

                        }
                        else
                        {
                            permissionLauncher.launch(Manifest.permission.CAMERA)
                        }
                        isDialogOpen = false
                    }) {
                        Text("Take a photo")
                    }
                    TextButton(onClick = {
                        multiplePhotoPickerLauncher.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                        isDialogOpen = false
                    }) {
                        Text("Choose from gallery")
                    }
                }
            },
            confirmButton = { },
            dismissButton = { }
        )
    }
}

fun Context.createImageFile(): File {
    val timeStamp = SimpleDateFormat("yyyy_MM_dd_HH:mm:ss").format(Date())
    val imageFileName = "JPEG_" + timeStamp + "_"
    val image = File.createTempFile(
        imageFileName,
        ".jpg",
        externalCacheDir
    )
    return image
}