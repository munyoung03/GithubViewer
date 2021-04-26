package com.example.githubviewer.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubviewer.data.model.search.Search
import com.example.githubviewer.data.model.users.Users
import com.example.githubviewer.data.util.Resource
import com.example.githubviewer.domain.usecase.GetSearchUseCase
import com.example.githubviewer.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class GithubViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val getSearchUseCase: GetSearchUseCase
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
 }