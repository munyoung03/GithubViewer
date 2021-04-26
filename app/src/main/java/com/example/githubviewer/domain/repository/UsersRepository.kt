package com.example.githubviewer.domain.repository

import com.example.githubviewer.data.model.search.Search
import com.example.githubviewer.data.model.users.Users
import com.example.githubviewer.data.model.users.UsersItem
import com.example.githubviewer.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    suspend fun getUsers(): Resource<Users>
    suspend fun getSearch(q:String) : Resource<Search>
    suspend fun saveUser(usersItem: UsersItem)
    fun getUser() : Flow<List<UsersItem>>
    suspend fun deleteUser(usersItem: UsersItem)
}