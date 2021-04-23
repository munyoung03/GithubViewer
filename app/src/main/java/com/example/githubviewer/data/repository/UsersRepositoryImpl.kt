package com.example.githubviewer.data.repository

import com.example.githubviewer.data.model.search.Search
import com.example.githubviewer.data.model.users.Users
import com.example.githubviewer.data.repository.datasource.UserRemoteDataSource
import com.example.githubviewer.data.util.Resource
import com.example.githubviewer.domain.repository.UsersRepository
import retrofit2.Response

class UsersRepositoryImpl (
        private val userRemoteDataSource: UserRemoteDataSource,
):UsersRepository{
    override suspend fun getUsers(): Resource<Users> {
        return responseToResource(userRemoteDataSource.getUsers())
    }

    override suspend fun getSearch(q: String): Resource<Search> {
        return responseToResourceSearch(userRemoteDataSource.getSearch(q))
    }

    private fun responseToResource(response: Response<Users>):Resource<Users>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    private fun responseToResourceSearch(response: Response<Search>):Resource<Search>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}