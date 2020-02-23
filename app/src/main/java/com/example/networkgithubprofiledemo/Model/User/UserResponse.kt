package com.example.networkgithubprofiledemo.Model.User

data class UserResponse(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val repos: List<UserRepos>,
    val total_count: Int
)