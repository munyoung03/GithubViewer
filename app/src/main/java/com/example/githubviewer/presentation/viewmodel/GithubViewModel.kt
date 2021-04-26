package com.example.githubviewer.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.githubviewer.data.model.search.Search
import com.example.githubviewer.data.model.users.Users
import com.example.githubviewer.data.model.users.UsersItem
import com.example.githubviewer.data.util.Resource
import com.example.githubviewer.domain.usecase.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception

class GithubViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val getSearchUseCase: GetSearchUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val saveUserUseCase: SaveUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase
) : ViewModel() {

    val usersLists: MutableLiveData<Resource<Users>> = MutableLiveData()

    fun getUserList() = viewModelScope.launch(Dispatchers.IO){
        usersLists.postValue(Resource.Loading())

        try {
            val apiResult = getUsersUseCase.execute()
            usersLists.postValue(apiResult)
        }catch (e:Exception){
            usersLists.postValue(Resource.Error(e.toString()))
        }
    }

    val searchLists: MutableLiveData<Resource<Search>> = MutableLiveData()

    fun getSearchList(q:String) = viewModelScope.launch(Dispatchers.IO) {
        searchLists.postValue(Resource.Loading())

        try {
            val apiResult = getSearchUseCase.execute(q)
            searchLists.postValue(apiResult)
        }catch (e:Exception){
            searchLists.postValue(Resource.Error(e.toString()))
        }
    }

    fun getLocalUserList() = liveData {
        getUserUseCase.execute().collect {
            emit(it)
        }
    }

    fun saveUser(usersItem: UsersItem) = viewModelScope.launch {
        saveUserUseCase.execute(usersItem)
    }

    fun deleteUser(usersItem: UsersItem) = viewModelScope.launch {
        deleteUserUseCase.execute(usersItem)
    }
 }