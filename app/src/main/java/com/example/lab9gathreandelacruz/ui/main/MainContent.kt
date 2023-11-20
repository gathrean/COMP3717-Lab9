package com.example.lab9gathreandelacruz.ui.main


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab9gathreandelacruz.data.LocalUser

@Composable
fun MainContent(usersState: UsersState) {

    val signupState = remember { SignUpState() }

    val deleteCallback = { user: LocalUser ->
        usersState.deleteEntity(user)
        usersState.refresh()
    }

    val replaceCallback = { user: LocalUser ->
        signupState.uid = user.uid.toString()
        signupState.name = user.name!!
        signupState.email = user.email!!
    }

    Column {
        // Sign up form using name and email
        Column {
            MyTextField(signupState.name, signupState.onNameChanged)
            MyTextField(signupState.email, signupState.onEmailChanged)
        }
//        SignUpComposable()
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                usersState.insertEntity(
                    LocalUser(
                        name = signupState.name,
                        email = signupState.email
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
fun UserItem(user: LocalUser, delete: (LocalUser) -> Unit, replace: (LocalUser) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                replace(user)
            }
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFFFFFFF))
            .height(80.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(user.name!!, fontSize = 20.sp, modifier = Modifier.padding(10.dp))
        Text(user.email!!, fontSize = 20.sp)
        IconButton(
            onClick = { delete(user) }) {
            Icon(Icons.Rounded.Close, contentDescription = null)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(value: String, onValueChanged: (String) -> Unit) {
    // "Pass down state"
    TextField(
        value = value,
        onValueChange = {
            onValueChanged(it)
        },
        modifier = Modifier.fillMaxWidth()
    )
}