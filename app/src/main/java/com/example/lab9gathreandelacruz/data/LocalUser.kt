package com.example.lab9gathreandelacruz.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table") // Specifies the table name as "users_table" in the database
data class LocalUser(
    // uid = unique identifier
    // This field represents the primary key, and it has to be unique
    @PrimaryKey(autoGenerate = true) val uid: Int? = null, // Auto-generates a unique ID if not provided
    @ColumnInfo(name = "first_name") val name: String? = null, // Specifies the column name as "first_name"
    @ColumnInfo(name = "user_email") val email: String? = null // Specifies the column name as "user_email"
)