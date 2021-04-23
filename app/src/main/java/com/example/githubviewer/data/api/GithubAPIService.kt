package com.example.githubviewer.data.api

import com.example.githubviewer.data.model.search.Search
import com.example.githubviewer.data.model.users.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubAPIService {
    @GET("/users")
    suspend fun getUsers() : Response<Users>

    @GET("/search/users")
    suspend fun getSearchUser(
        @Query("q", encoded = true) q : String
    ) : Response<Search>
}