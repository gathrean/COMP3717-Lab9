package com.example.lab9gathreandelacruz.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.lab9gathreandelacruz.data.LocalUser
import com.example.lab9gathreandelacruz.data.UsersRepository


/**
 * This class manages the UI state related to users by utilizing the UsersRepository
 */
class UsersState(private val usersRepository: UsersRepository) {
    // doesn't have business logic, but it gives us access to the business logic
    // which is in the repository

    // Mutable state containing the list of users fetched from the repository
    var users by mutableStateOf(usersRepository.getAll())

    // Refreshes the list of users by fetching the data again from the repository
    fun refresh() {
        users = usersRepository.getAll()
    }

    // Inserts a user into the repository
    fun insertEntity(user: LocalUser) {
        usersRepository.insertEntity(user)
    }

    // Deletes a user from the repository
    fun deleteEntity(user: LocalUser) {
        usersRepository.deleteEntity(user)
    }
}