package com.example.lab9gathreandelacruz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.example.lab9gathreandelacruz.ui.main.MainContent
import com.example.lab9gathreandelacruz.ui.main.UsersState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val usersRepository = (application as MyApp).userRepository

        setContent {
            val usersState = remember {
                UsersState(usersRepository)
            }

            MainContent(usersState)
        }
    }
}
