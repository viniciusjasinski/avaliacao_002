package com.example.avaliacao2githubapi.repository

import com.example.avaliacao2githubapi.model.DataRepositories
import com.example.avaliacao2githubapi.model.DescriptionRepository
import com.example.avaliacao2githubapi.service.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoriesGithub {

    private val service = RetrofitBuilder.getAllGitHubRepositories()

    fun getAllRepositories(callReturn: (DataRepositories?, String?) -> Unit) {
        val callback = service.getAllJavaRepositories()

        callback.enqueue(object : Callback<DataRepositories> {
            override fun onResponse(
                call: Call<DataRepositories>,
                response: Response<DataRepositories>
            ) {
                if (response.body() != null) {
                    callReturn(response.body(), null)
                } else {
                    callReturn(null, "Erro diferente")
                }
            }

            override fun onFailure(call: Call<DataRepositories>, t: Throwable) {
                callReturn(null, t.message)
            }
        })
    }

    fun getAllPullRequestsDetails(
        username: String,
        repositoryName: String,
        callReturn: (List<DescriptionRepository>?, String?) -> Unit
    ) {
        val callback = service.getAllPullsFromRepository(username, repositoryName)

        callback.enqueue(object : Callback<List<DescriptionRepository>> {
            override fun onResponse(
                call: Call<List<DescriptionRepository>>,
                response: Response<List<DescriptionRepository>>
            ) {
                if (response.body() != null) {
                    callReturn(response.body(), null)
                } else {
                    callReturn(null, "Erro diferente")
                }
            }

            override fun onFailure(call: Call<List<DescriptionRepository>>, t: Throwable) {
                callReturn(null, t.message)
            }

        })

    }


}