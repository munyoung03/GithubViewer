package com.example.githubviewer.domain.repository

import com.example.githubviewer.data.api.GithubAPIService
import com.example.githubviewer.data.util.Resource

interface UsersRepository {
    suspend fun getUsers(): Resource<GithubAPIService>
}