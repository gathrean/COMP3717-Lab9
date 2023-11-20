package com.example.lab9gathreandelacruz.ui.main


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.lab9gathreandelacruz.data.LocalUser

@Composable
fun MainContent(usersState: UsersState) {

    val signUpState = remember { SignUpState() }

    Column {
        // Sign up form using name and email
        Column {
            MyTextField(signUpState.name, signUpState.onNameChanged)
            MyTextField(signUpState.email, signUpState.onEmailChanged)
        }
//        SignUpComposable()
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                usersState.insertEntity(
                    LocalUser(
                        name = signUpState.name,
                        email = signUpState.email
                    )
                )
            }) {
                Text(text = "Add")
            }
            Button(onClick = {
                usersState.refresh()
            }) {
                Text(text = "Refresh")
            }
        }
        LazyColumn {
            items(usersState.users.size) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(usersState.users[it].name!!, fontSize = 30.sp)
                    Text(usersState.users[it].name!!, fontSize = 30.sp)
                }
            }
        }
    }
}

@Composable
fun SignUpComposable() {

    // This got moved to SignUpState class, and replaced with val signUpState
    /*
        // For the name field
        var name by remember { mutableStateOf("") }
        val onNameChanged: (String) -> Unit = {
            name = it
        }

        // For the email field
        var email by remember{ mutableStateOf("") }
        val onEmailChanged: (String) -> Unit = {
            email = it
        }
     */

//    val signUpState = remember{ SignUpState() }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(value: String, onValueChanged: (String) -> Unit) {
    // Make composable stateless so that it can be reused

    // "Single source of truth"
    // Because you only want one source of truth that doesn't change
    // And you want it clear
//    var value by remember { mutableStateOf("") }

    // "Pass down state"
    TextField(
        value = value,
        onValueChange = {
            onValueChanged(it)
        },
        modifier = Modifier.fillMaxWidth()
    )
}