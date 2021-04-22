package com.example.githubviewer.data.repository.datasource

import com.example.githubviewer.data.api.GithubAPIService
import com.example.githubviewer.data.model.Users
import retrofit2.Response

interface UserRemoteDataSource {
    suspend fun getUsers():Response<Users>
}