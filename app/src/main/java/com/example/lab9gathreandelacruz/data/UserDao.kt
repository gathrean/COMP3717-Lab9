package com.example.lab9gathreandelacruz.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// DAO = Data Access Object
@Dao
interface UserDao {

    // Retrieves all users from the users_table in the database
    @Query("SELECT * FROM users_table")
    fun getAll(): List<LocalUser>

    // Inserts a user into the users_table in the database
    @Insert(onConflict = OnConflictStrategy.REPLACE) // Specifies that if there's a conflict (same user), replace it
    fun insert(user: LocalUser)

    // Deletes a specific user from the users_table in the database
    @Delete
    fun delete(user: LocalUser)
}
