package com.example.githubviewer.presentation.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubviewer.data.api.GithubAPIService
import com.example.githubviewer.data.model.Users
import com.example.githubviewer.data.model.UsersItem
import com.example.githubviewer.data.util.Resource
import com.example.githubviewer.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class GithubViewModel(
    private val getUsersUseCase: GetUsersUseCase
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
 }