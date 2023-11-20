package com.example.lab9gathreandelacruz.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab9gathreandelacruz.data.LocalUser

/**
 * MainContent is the main UI composable function.
 * It contains the UI for the list of users and the form to add a new user.
 */
@Composable
fun MainContent(usersState: UsersState) {

    // Remember composable used to remember the state of the SignUpState
    val signupState = remember { SignUpState() }

    // Callback to delete a user from the list
    val deleteCallback = { user: LocalUser ->
        usersState.deleteEntity(user)
        usersState.refresh()
    }

    // Callback to replace user data in the form fields
    val replaceCallback = { user: LocalUser ->
        signupState.uid = user.uid.toString()
        signupState.name = user.name!!
        signupState.email = user.email!!
    }

    // Main Column to organize the UI elements
    Column {

        // User input fields for UID, Name, and Email
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
        ) {
            signupState.uid?.let { CustomTextField(it, signupState.onUidChanged, "UID:") }
            CustomTextField(signupState.name, signupState.onNameChanged, "Name: ")
            CustomTextField(signupState.email, signupState.onEmailChanged, "Email: ")
        }

        // Buttons for Add and Refresh
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            // "Add" button for adding a new user
            Button(onClick = {
                usersState.insertEntity(
                    LocalUser(
                        uid = signupState.uid?.toIntOrNull(),
                        name = signupState.name,
                        email = signupState.email
                    )
                )
            }) {
                Text(text = "Add", fontSize = 20.sp)
            }

            // Spacer between the buttons
            Spacer(modifier = Modifier.padding(30.dp))

            // "Refresh" button to reload user data
            Button(onClick = { usersState.refresh() }) {
                Text(text = "Refresh", fontSize = 20.sp)
            }
        }

        // LazyColumn to display the list of users
        LazyColumn {
            items(usersState.users.size) {
                UserItem(usersState.users[it], deleteCallback, replaceCallback)
            }
        }
    }
}

/**
 * Composable function to display a single user in the list.
 */
@Composable
fun UserItem(user: LocalUser, delete: (LocalUser) -> Unit, replace: (LocalUser) -> Unit) {
    // Row to display user information and delete button
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { replace(user) } // Click on a user item triggers replace callback
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFe7e0eb)) // Light purple background
            .height(80.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(user.name!!, fontSize = 20.sp, modifier = Modifier.padding(10.dp)) // Display user name
        Text(user.email!!, fontSize = 20.sp) // Display user email
        IconButton(
            onClick = { delete(user) }) {
            Icon(Icons.Rounded.Close, contentDescription = null) // Delete button
        }
    }
}

/**
 * Composable function to display a text field with a title.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(value: String, onValueChanged: (String) -> Unit, textFieldTitle: String) {
    Text(textFieldTitle)
    TextField(
        value = value,
        onValueChange = { onValueChanged(it) },
        modifier = Modifier.fillMaxWidth()
    )
}