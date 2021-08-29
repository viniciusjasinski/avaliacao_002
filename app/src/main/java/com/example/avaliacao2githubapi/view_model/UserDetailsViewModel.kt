package com.example.avaliacao2githubapi.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.avaliacao2githubapi.model.UserInformation
import com.example.avaliacao2githubapi.repository.RepositoriesGithub

class UserDetailsViewModel : ViewModel() {

    private val _userInformation = MutableLiveData<UserInformation>()
    val userInformation: LiveData<UserInformation> = _userInformation

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val repository = RepositoriesGithub()

    fun fetchUserData(username: String) {

        repository.getUserInformation(username) { information, error ->

            if(information != null) {
                _userInformation.value = information
            } else {
                _error.value = error
            }

        }

    }

}