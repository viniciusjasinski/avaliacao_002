package com.example.avaliacao2githubapi.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.avaliacao2githubapi.model.DescriptionRepository
import com.example.avaliacao2githubapi.repository.RepositoriesGithub

class RepositoryDetailsViewModel : ViewModel() {

    private val _repositoryDetails = MutableLiveData<List<DescriptionRepository>>()
    val repositoryDetails: LiveData<List<DescriptionRepository>> = _repositoryDetails

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val repository = RepositoriesGithub()

    fun fetchAllPullRequestsFromARepository(repositoryName: String, username: String) {

        repository.getAllPullRequestsDetails(username, repositoryName) { response, error ->

            if(response != null) {
                _repositoryDetails.value = response
            } else {
                _error.value = error
            }

        }
    }

}