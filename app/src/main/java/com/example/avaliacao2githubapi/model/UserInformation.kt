package com.example.avaliacao2githubapi.model

import com.google.gson.annotations.SerializedName

data class UserInformation(

    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("bio")
    val bio: String,

)
