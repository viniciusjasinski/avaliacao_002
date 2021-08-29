package com.example.avaliacao2githubapi.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.avaliacao2githubapi.model.DataRepositories
import com.example.avaliacao2githubapi.repository.RepositoriesGithub

class AllRepositoriesViewModel : ViewModel() {

    private val _dataRepositories = MutableLiveData<DataRepositories>()
    val dataRepositories: LiveData<DataRepositories> = _dataRepositories

    private val _errorGetRepositories = MutableLiveData<String>()
    val errorGetRepositories: LiveData<String> = _errorGetRepositories

    private val repository = RepositoriesGithub()

    fun fetchAllRepositories() {

        repository.getAllRepositories{ response, error ->

            if(response != null) {
                _dataRepositories.value = response
            } else {
                _errorGetRepositories.value = error
            }

        }

    }



}