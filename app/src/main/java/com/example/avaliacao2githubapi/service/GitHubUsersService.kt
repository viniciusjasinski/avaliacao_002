package com.example.avaliacao2githubapi.service

import com.example.avaliacao2githubapi.model.DataRepositories
import com.example.avaliacao2githubapi.model.DescriptionRepository
import com.example.avaliacao2githubapi.model.UserInformation
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubUsersService {

    @GET("/search/repositories?q=language:Java&sort=stars&page=1")
    fun getAllJavaRepositories(): Call<DataRepositories>

    @GET("/repos/{username}/{repositoryName}/pulls")
    fun getAllPullsFromRepository(
        @Path ("username") username: String,
        @Path ("repositoryName") repositoryName: String): Call<List<DescriptionRepository>>

    @GET("/users/{username}")
    fun getUserInformation(@Path("username") username: String): Call<UserInformation>


}