package com.example.avaliacao2githubapi.model

import com.google.gson.annotations.SerializedName

data class AllRepositories(
    @SerializedName("items")
    val items: List<RepositoriesDetails>
)

data class RepositoriesDetails(
    @SerializedName("name")
    val repositoryName: String,
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
    val authorName: String,
    @SerializedName("avatar_url")
    val authorAvatar: String,

)
