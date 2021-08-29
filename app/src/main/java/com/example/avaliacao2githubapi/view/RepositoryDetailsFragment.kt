package com.example.avaliacao2githubapi.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.avaliacao2githubapi.R
import com.example.avaliacao2githubapi.adapter.PullRequestsDetailsAdapter
import com.example.avaliacao2githubapi.databinding.RepositoryDetailsFragmentBinding
import com.example.avaliacao2githubapi.model.DescriptionRepository
import com.example.avaliacao2githubapi.view_model.RepositoryDetailsViewModel
import com.google.android.material.snackbar.Snackbar

class RepositoryDetailsFragment : Fragment(R.layout.repository_details_fragment) {

    companion object {
        fun newInstance(repositoryFullName: String) : RepositoryDetailsFragment{
            return RepositoryDetailsFragment().apply {
                val args = Bundle()
                args.putString("full_name_parameter", repositoryFullName)
                this.arguments = args
            }
        }
    }

    private lateinit var viewModel: RepositoryDetailsViewModel
    private lateinit var binding: RepositoryDetailsFragmentBinding
    private var adapter = PullRequestsDetailsAdapter{

    }

    private val observerPullDetails = Observer<DescriptionRepository> {

    }

    private val observerError = Observer<String> {
        Snackbar.make(requireView(), it, Snackbar.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = RepositoryDetailsFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(RepositoryDetailsViewModel::class.java)

        val fullNameReceive = arguments?.getString("full_name_parameter")

        binding.recyclerViewRepositoryPullDetails.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewRepositoryPullDetails.adapter = adapter

        viewModel.repositoryDetails.observe(viewLifecycleOwner, observerPullDetails)
        viewModel.error.observe(viewLifecycleOwner, observerError)

        if(fullNameReceive != null) {
            viewModel.fetchAllPullRequestsFromARepository(fullNameReceive!!)
        }

    }


}