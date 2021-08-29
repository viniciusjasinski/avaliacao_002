package com.example.avaliacao2githubapi

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class RepositoryDetailsFragment : Fragment(R.layout.repository_details_fragment) {

    companion object {
        fun newInstance() = RepositoryDetailsFragment()
    }

    private lateinit var viewModel: RepositoryDetailsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(RepositoryDetailsViewModel::class.java)

    }


}