package com.example.avaliacao2githubapi.model

import com.google.gson.annotations.SerializedName

data class DescriptionRepository(

    @SerializedName("user")
    val userPullRequest: UserPullRequest,
    @SerializedName("title")
    val titlePullRequest: String,
    @SerializedName("body")
    val bodyPullRequest: String,
    @SerializedName("created_at")
    val PullRequestDate: String

)

data class UserPullRequest(
    @SerializedName("login")
    val usernameUserPullRequest: String,
    @SerializedName("avatar_url")
    val avatarUserPullRequest: String,

)
