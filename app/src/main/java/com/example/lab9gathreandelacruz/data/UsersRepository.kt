package com.example.lab9gathreandelacruz.data

class UsersRepository(private val userDao: UserDao) {

    // Inserts a user into the database using the provided UserDao
    fun insertEntity(user: LocalUser) {
        userDao.insert(user)
    }

    // Retrieves all users from the database using the UserDao
    fun getAll(): List<LocalUser> {
        return userDao.getAll()
    }

    // Deletes a user from the database using the UserDao
    fun deleteEntity(user: LocalUser) {
        userDao.delete(user)
    }

    // Additional business logic can be implemented here
    // For instance, preventing duplicate emails or other complex operations
}
