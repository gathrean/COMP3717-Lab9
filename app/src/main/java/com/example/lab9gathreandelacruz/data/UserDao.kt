package com.example.lab9gathreandelacruz.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// DAO = data access object

@Dao
interface UserDao {
    // these are convenience annotations, we don't really have to use them

    @Query("SELECT * FROM users_table")
    fun getAll(): List<LocalUser>

    @Insert(onConflict = OnConflictStrategy.REPLACE) // replace the user with the new one if it already exists
    fun insert(user: LocalUser)

    @Delete
    fun delete(user: LocalUser) // delete a specific user
}