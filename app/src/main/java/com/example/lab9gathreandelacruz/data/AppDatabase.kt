package com.example.lab9gathreandelacruz.data

import androidx.room.Database
import androidx.room.RoomDatabase

// change version number when you're testing
@Database(entities = [LocalUser::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}