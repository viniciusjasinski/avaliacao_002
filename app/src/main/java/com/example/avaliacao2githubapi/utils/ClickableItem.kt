package com.example.avaliacao2githubapi.utils

import com.example.avaliacao2githubapi.model.RepositoriesDetails

interface ClickableItem {

    fun onClickItemList(repo: RepositoriesDetails)

    fun onClickImage(repo: RepositoriesDetails)

}