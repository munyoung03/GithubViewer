package com.example.githubviewer.domain.usecase

import com.example.githubviewer.domain.repository.UsersRepository

class GetSearchUseCase(private val usersRepository: UsersRepository) {
    suspend fun execute(q:String)  = usersRepository.getSearch(q)
}