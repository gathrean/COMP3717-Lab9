package com.example.lab9gathreandelacruz

import android.app.Application
import androidx.room.Room
import com.example.lab9gathreandelacruz.data.AppDatabase
import com.example.lab9gathreandelacruz.data.UsersRepository

class MyApp : Application() {

    // Using lazy initialization for the database instance
    private val db by lazy {
        // Initializes Room database using databaseBuilder method
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, // Specifies the database class (AppDatabase) - using Java class reference
            "my-database" // Specifies the database name as "my-database"
        )
            .allowMainThreadQueries() // Allows database queries on the main thread (not recommended in production)
            .build() // Builds the Room database
    }

    // Lazily initializes the UsersRepository using the database's userDao
    val userRepository by lazy { UsersRepository(db.userDao()) }
}