package com.example.lab9gathreandelacruz

import android.app.Application
import androidx.room.Room
import com.example.lab9gathreandelacruz.data.AppDatabase
import com.example.lab9gathreandelacruz.data.UsersRepository

class MyApp : Application() {

    // lazy becomes it's really heavy and we only want to initialize it once
    private val db by lazy {
        // stored locally in our device and stored specifically for our app
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, // use java because its dependencies were made way before kotlin
            "my-database"
        )
            .allowMainThreadQueries()
            .build()
    }

    // local repository
    val userRepository by lazy { UsersRepository(db.userDao()) }
}