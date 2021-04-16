package com.example.githubviewer.data.api

import com.example.githubviewer.data.util.Resource
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubAPIService {
    @GET("/users")
    suspend fun getUsers() : Resource<GithubAPIService>
}