package com.example.lab9gathreandelacruz.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table") // specifying the name of the table, instead of just LocalUser
data class LocalUser(
    // uid = unique identifier
    // this is the primary key so it has to be unique
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    @ColumnInfo(name = "first_name") val name: String? = null,
    @ColumnInfo(name = "user_email") val email: String? = null
)