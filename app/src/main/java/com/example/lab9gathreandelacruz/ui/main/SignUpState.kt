package com.example.lab9gathreandelacruz.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

// this is the state holder
// notice we don't have to use remember keyword here
class SignUpState {
    // For the name field
    var name by mutableStateOf("")
    val onNameChanged: (String) -> Unit = { name = it }

    // For the email field
    var email by mutableStateOf("")
    val onEmailChanged: (String) -> Unit = {
        email = it
        validEmail = email.contains("@") // this is UI logic state holder
    }

    var validEmail = false

    var uid by mutableStateOf<String?>("")
    val onUidChanged: (String) -> Unit = { uid = it }
}