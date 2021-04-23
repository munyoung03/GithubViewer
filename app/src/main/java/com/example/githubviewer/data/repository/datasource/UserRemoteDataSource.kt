package com.example.githubviewer.data.repository.datasource

import com.example.githubviewer.data.model.search.Search
import com.example.githubviewer.data.model.users.Users
import retrofit2.Response

interface UserRemoteDataSource {
    suspend fun getUsers():Response<Users>
    suspend fun getSearch(q : String):Response<Search>
}