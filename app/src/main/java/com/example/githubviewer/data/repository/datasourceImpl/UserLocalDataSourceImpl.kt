package com.example.githubviewer.data.repository.datasourceImpl

import com.example.githubviewer.data.db.UserDAO
import com.example.githubviewer.data.model.users.UsersItem
import com.example.githubviewer.data.repository.datasource.UserLocalDataSource
import kotlinx.coroutines.flow.Flow

class UserLocalDataSourceImpl(private val userDAO: UserDAO) : UserLocalDataSource {
    override suspend fun saveUser(usersItem: UsersItem) {
        userDAO.insert(usersItem)
    }

    override fun getUser(): Flow<List<UsersItem>> {
        return userDAO.getUsers()
    }

    override suspend fun deleteUser(usersItem: UsersItem) {
        userDAO.deleteUser(usersItem)
    }
}