package com.example.githubviewer.data.repository

import com.example.githubviewer.data.api.GithubAPIService
import com.example.githubviewer.data.repository.datasource.UserRemoteDataSource
import com.example.githubviewer.data.util.Resource
import com.example.githubviewer.domain.repository.UsersRepository
import retrofit2.Response

class UsersRepositoryImpl (
        private val userRemoteDataSource: UserRemoteDataSource,
):UsersRepository{
    override suspend fun getUsers(): Resource<GithubAPIService> {
        return responseToResource(userRemoteDataSource.getUsers())
    }

    private fun responseToResource(response: Response<GithubAPIService>):Resource<GithubAPIService>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}