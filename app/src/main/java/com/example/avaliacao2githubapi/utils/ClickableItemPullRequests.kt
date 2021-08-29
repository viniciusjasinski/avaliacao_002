package com.example.avaliacao2githubapi.utils

import com.example.avaliacao2githubapi.model.DescriptionRepository

interface ClickableItemPullRequests {

    fun onClickList(repo: DescriptionRepository)

    fun onClickImage(repo: DescriptionRepository)

}