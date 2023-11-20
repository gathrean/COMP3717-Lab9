package com.example.lab9gathreandelacruz.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * State holder for the SignUp UI
 * No need to user the 'remember' keyword as it's not a Composable function
 */
class SignUpState {
    // Mutable state variables for managing form fields

    // For the name field
    var name by mutableStateOf("")
    // Function to update the name when its value changes
    val onNameChanged: (String) -> Unit = { name = it }

    // For the email field
    var email by mutableStateOf("")
    // Function to update the email when its value changes
    val onEmailChanged: (String) -> Unit = {
        email = it
        // This flag tracks if the email contains '@', representing a basic validation (UI logic state holder)
        validEmail = email.contains("@")
    }

    // Private state variable to track email validation
    private var validEmail = false

    // For the UID field
    var uid by mutableStateOf<String?>("")
    // Function to update the 'uid' variable when its value changes
    val onUidChanged: (String) -> Unit = { uid = it }
}