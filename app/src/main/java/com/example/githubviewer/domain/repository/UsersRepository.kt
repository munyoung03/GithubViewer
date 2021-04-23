package com.example.githubviewer.domain.repository

import com.example.githubviewer.data.model.search.Search
import com.example.githubviewer.data.model.users.Users
import com.example.githubviewer.data.util.Resource

interface UsersRepository {
    suspend fun getUsers(): Resource<Users>
    suspend fun getSearch(q:String) : Resource<Search>
}