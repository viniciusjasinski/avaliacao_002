package com.example.avaliacao2githubapi.service

import com.example.avaliacao2githubapi.model.AllRepositories
import retrofit2.Call
import retrofit2.http.GET

interface GitHubUsersService {

    @GET("/search/repositories?q=language:Java&sort=stars&page=1")
    fun getAllJavaRepositories(): Call<AllRepositories>

}