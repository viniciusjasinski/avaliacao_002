package com.example.avaliacao2githubapi.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.avaliacao2githubapi.R
import com.example.avaliacao2githubapi.adapter.RepositoriesAdapter
import com.example.avaliacao2githubapi.databinding.AllRepositoriesFragmentBinding
import com.example.avaliacao2githubapi.model.AllRepositories
import com.example.avaliacao2githubapi.view_model.AllRepositoriesViewModel
import com.google.android.material.snackbar.Snackbar

class AllRepositoriesFragment : Fragment(R.layout.all_repositories_fragment) {

    companion object {
        fun newInstance() = AllRepositoriesFragment()
    }

    private lateinit var viewModel: AllRepositoriesViewModel
    private lateinit var binding: AllRepositoriesFragmentBinding
    private val adapter = RepositoriesAdapter()

    private val observerRepositories = Observer<AllRepositories> {
        adapter.refresh(it.items)
    }

    private val observerError = Observer<String> {
        Snackbar.make(requireView(), it, Snackbar.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = AllRepositoriesFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(AllRepositoriesViewModel::class.java)

        binding.recyclerViewAllRepositories.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewAllRepositories.adapter = adapter

//        adapter.refresh(viewModel.allRepositories)

        viewModel.allRepositories.observe(viewLifecycleOwner, observerRepositories)
        viewModel.errorGetRepositories.observe(viewLifecycleOwner, observerError)

        viewModel.fetchAllRepositories()

    }

}