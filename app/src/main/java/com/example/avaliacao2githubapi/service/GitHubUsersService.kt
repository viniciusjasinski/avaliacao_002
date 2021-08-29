package com.example.avaliacao2githubapi.service

import com.example.avaliacao2githubapi.model.DataRepositories
import com.example.avaliacao2githubapi.model.DescriptionRepository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubUsersService {

    @GET("/search/repositories?q=language:Java&sort=stars&page=1")
    fun getAllJavaRepositories(): Call<DataRepositories>

    @GET("/repos/{fullname}/pulls")
    fun getAllPullsFromUser(@Path ("fullname") fullname: String): Call<DescriptionRepository>

}