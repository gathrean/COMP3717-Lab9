package com.example.lab9gathreandelacruz.data

class UsersRepository(private val userDao: UserDao) {

    // inserts a user into the database
    fun insertEntity(user: LocalUser){
        userDao.insert(user)
    }

    // gets all the users from the database
    fun getAll(): List<LocalUser> {
        return userDao.getAll()
    }

    fun deleteEntity(user: LocalUser) {
        userDao.delete(user)
    }

    // business logics would go here
    // for example, preventing duplicate emails
}