package com.example.githubviewer.domain.usecase

import com.example.githubviewer.domain.repository.UsersRepository

class GetUserUseCase(private val usersRepository: UsersRepository) {
    fun execute() = usersRepository.getUser()
}