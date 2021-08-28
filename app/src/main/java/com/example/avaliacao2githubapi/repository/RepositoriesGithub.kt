package com.example.avaliacao2githubapi.repository

import com.example.avaliacao2githubapi.model.AllRepositories
import com.example.avaliacao2githubapi.service.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoriesGithub {

    private val service = RetrofitBuilder.getAllGitHubRepositories()

    fun getAllRepositories(callReturn: (AllRepositories?, String?) -> Unit) {
        val callback = service.getAllJavaRepositories()

        callback.enqueue(object: Callback<AllRepositories> {
            override fun onResponse(
                call: Call<AllRepositories>,
                response: Response<AllRepositories>
            ) {
                if(response.body() != null) {
                    callReturn(response.body(), null)
                } else {
                    callReturn(null, "Erro que recebeu uma resposta de conexao efetuada")
                }
            }

            override fun onFailure(call: Call<AllRepositories>, t: Throwable) {
                callReturn(null, t.message)
            }
        })
    }


}