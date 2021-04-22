package com.example.githubviewer.data.repository.datasourceImpl

import com.example.githubviewer.data.api.GithubAPIService
import com.example.githubviewer.data.model.Users
import com.example.githubviewer.data.repository.datasource.UserRemoteDataSource
import retrofit2.Response

class UserRemoteDataSourceImpl(
        private val githubAPIService: GithubAPIService
): UserRemoteDataSource{
    override suspend fun getUsers(): Response<Users> {
        return githubAPIService.getUsers()
    }
}