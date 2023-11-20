package com.example.lab9gathreandelacruz.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.lab9gathreandelacruz.data.LocalUser
import com.example.lab9gathreandelacruz.data.UsersRepository

// doesn't have business logic, but it gives us access to the business logic
// which is in the repository
class UsersState(private val usersRepository: UsersRepository) {

    var users by mutableStateOf(usersRepository.getAll())

    fun refresh(){
        users = usersRepository.getAll()
    }

    fun insertEntity(user: LocalUser) {
        usersRepository.insertEntity(user)
    }

    fun deleteEntity(user: LocalUser) {
        usersRepository.deleteEntity(user)
    }
}