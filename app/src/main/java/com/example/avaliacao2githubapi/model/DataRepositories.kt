package com.example.avaliacao2githubapi.model

import com.google.gson.annotations.SerializedName

data class DataRepositories(
    @SerializedName("items")
    val items: List<RepositoriesDetails>
)

data class RepositoriesDetails(
    @SerializedName("name")
    val repositoryName: String,
    @SerializedName("full_name")
    val repositoryFullName: String,
    @SerializedName("owner")
    val owner: OwnerDetails,
    @SerializedName("description")
    val description: String,
    @SerializedName("stargazers_count")
    val stars: Long,
    @SerializedName("forks")
    val forks: Long,

)

data class OwnerDetails(
    @SerializedName("login")
    val authorUsername: String,
    @SerializedName("avatar_url")
    val authorAvatar: String,

)
