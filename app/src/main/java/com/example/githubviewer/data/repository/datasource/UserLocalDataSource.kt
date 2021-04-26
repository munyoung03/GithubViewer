package com.example.githubviewer.data.repository.datasource

import com.example.githubviewer.data.model.users.UsersItem
import kotlinx.coroutines.flow.Flow

interface UserLocalDataSource {
    suspend fun saveUser(usersItem: UsersItem)
    fun getUser() : Flow<List<UsersItem>>
    suspend fun deleteUser(usersItem: UsersItem)
}