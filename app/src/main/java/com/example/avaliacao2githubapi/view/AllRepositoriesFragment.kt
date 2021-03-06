package com.example.avaliacao2githubapi.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.avaliacao2githubapi.MainActivity
import com.example.avaliacao2githubapi.R
import com.example.avaliacao2githubapi.adapter.RepositoriesAdapter
import com.example.avaliacao2githubapi.databinding.AllRepositoriesFragmentBinding
import com.example.avaliacao2githubapi.model.DataRepositories
import com.example.avaliacao2githubapi.model.RepositoriesDetails
import com.example.avaliacao2githubapi.utils.ClickableItem
import com.example.avaliacao2githubapi.view_model.AllRepositoriesViewModel
import com.google.android.material.snackbar.Snackbar

class AllRepositoriesFragment : Fragment(R.layout.all_repositories_fragment), ClickableItem {

    companion object {
        fun newInstance() = AllRepositoriesFragment()
    }

    private lateinit var viewModel: AllRepositoriesViewModel
    private lateinit var binding: AllRepositoriesFragmentBinding
    private val adapter = RepositoriesAdapter(this)

    private val observerRepositories = Observer<DataRepositories> {
        adapter.refresh(it.items)
        binding.animationViewGithub.visibility = View.INVISIBLE
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

        viewModel.dataRepositories.observe(viewLifecycleOwner, observerRepositories)
        viewModel.errorGetRepositories.observe(viewLifecycleOwner, observerError)

        viewModel.fetchAllRepositories()

    }

    override fun onClickItemList(repo: RepositoriesDetails) {
        (requireActivity() as? MainActivity)?.changeFragments(RepositoryDetailsFragment.newInstance(repo.repositoryName, repo.owner.authorUsername))
    }

    override fun onClickImage(repo: RepositoriesDetails) {

        val bottomSheet = UserDetailsFragment.newInstance(repo.owner.authorUsername)
        bottomSheet.show(parentFragmentManager, "dialog_user_description")

    }

}