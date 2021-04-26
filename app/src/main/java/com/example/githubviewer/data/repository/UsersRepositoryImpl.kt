package com.example.githubviewer.data.repository

import com.example.githubviewer.data.model.search.Search
import com.example.githubviewer.data.model.users.Users
import com.example.githubviewer.data.model.users.UsersItem
import com.example.githubviewer.data.repository.datasource.UserLocalDataSource
import com.example.githubviewer.data.repository.datasource.UserRemoteDataSource
import com.example.githubviewer.data.util.Resource
import com.example.githubviewer.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class UsersRepositoryImpl (
        private val userRemoteDataSource: UserRemoteDataSource,
        private val userLocalDataSource: UserLocalDataSource
):UsersRepository{
    override suspend fun getUsers(): Resource<Users> {
        return responseToResource(userRemoteDataSource.getUsers())
    }

    override suspend fun getSearch(q: String): Resource<Search> {
        return responseToResourceSearch(userRemoteDataSource.getSearch(q))
    }

    override suspend fun saveUser(usersItem: UsersItem) {
        return userLocalDataSource.saveUser(usersItem)
    }

    override fun getUser(): Flow<List<UsersItem>> {
        return userLocalDataSource.getUser()
    }

    override suspend fun deleteUser(usersItem: UsersItem) {
        return userLocalDataSource.deleteUser(usersItem)
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