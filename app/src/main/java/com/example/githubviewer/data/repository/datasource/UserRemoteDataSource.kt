package com.example.githubviewer.data.repository.datasource

import com.example.githubviewer.data.api.GithubAPIService
import retrofit2.Response

interface UserRemoteDataSource {
    suspend fun getUsers():Response<GithubAPIService>
}