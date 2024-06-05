package com.example.newlotok.ui.screens.bookingScreen

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.MutableState
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.Firebase
import com.google.firebase.storage.storage
import java.util.UUID


fun hostPictures(
    picturesUrl: MutableState<List<Uri>>,
    picturesUri: List<Uri>,
    onSuccess: (List<Uri>) -> Unit,
    onFailure: (Exception) -> Unit
) {

    val storage = Firebase.storage
    val storageRef = storage.reference
    val uploadTasks = mutableListOf<Task<Uri>>()

    picturesUri.forEach { uri ->
        val childRef = storageRef.child("images/image${UUID.randomUUID()}.jpg")
        val uploadTask = childRef.putFile(uri)
            .continueWithTask { task ->
                if (!task.isSuccessful) {
                    task.exception?.let { throw it }
                }
                childRef.downloadUrl
            }
        uploadTasks.add(uploadTask)
        childRef.downloadUrl.addOnSuccessListener { uri ->
            Log.d("success: downloadUri", uri.toString())
        }
    }

    /*
    Tasks.whenAllComplete(uploadTasks).addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val downloadUrls = uploadTasks.mapNotNull { it.result }
            picturesUrl.value = downloadUrls
            onSuccess(downloadUrls)
        } else {
            onFailure(task.exception ?: Exception("Unknown error occurred"))
        }
    }
     */
}