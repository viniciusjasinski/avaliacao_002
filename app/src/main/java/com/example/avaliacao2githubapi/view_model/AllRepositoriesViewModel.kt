package com.example.avaliacao2githubapi.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.avaliacao2githubapi.model.AllRepositories
import com.example.avaliacao2githubapi.repository.RepositoriesGithub

class AllRepositoriesViewModel : ViewModel() {

    private val _allRepositories = MutableLiveData<AllRepositories>()
    private val allRepositories: LiveData<AllRepositories> = _allRepositories

    private val _errorGetRepositories = MutableLiveData<String>()
    private val errorGetRepositories: LiveData<String> = _errorGetRepositories

    private val repository = RepositoriesGithub()

    fun fetchAllRepositories() {

        repository.getAllRepositories{ response, error ->

            if(response != null) {
                _allRepositories.value = response
            } else {
                _errorGetRepositories.value = error
            }

        }

    }



}