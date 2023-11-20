package com.example.lab9gathreandelacruz.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

// DAO = data access object

@Dao
interface UserDao {
    // these are convenience annotations, we don't really have to use them

    @Query("SELECT * FROM users_table")
    fun getAll(): List<LocalUser>

    @Insert
    fun insert(user: LocalUser)
}