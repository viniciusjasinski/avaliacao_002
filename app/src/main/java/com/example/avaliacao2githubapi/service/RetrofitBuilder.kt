package com.example.avaliacao2githubapi.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getAllGitHubRepositories(): GitHubUsersService {
        return retrofit.create(GitHubUsersService::class.java)
    }

}