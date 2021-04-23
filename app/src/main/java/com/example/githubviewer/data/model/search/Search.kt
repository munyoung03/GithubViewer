package com.example.githubviewer.data.model.search

import com.example.githubviewer.data.model.users.UsersItem

data class Search(
    val incomplete_results: Boolean,
    val items: List<UsersItem>,
    val total_count: Int
)