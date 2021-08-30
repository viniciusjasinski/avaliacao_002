package com.example.avaliacao2githubapi.view

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.avaliacao2githubapi.MainActivity
import com.example.avaliacao2githubapi.R
import com.example.avaliacao2githubapi.adapter.PullRequestsDetailsAdapter
import com.example.avaliacao2githubapi.databinding.RepositoryDetailsFragmentBinding
import com.example.avaliacao2githubapi.model.DescriptionRepository
import com.example.avaliacao2githubapi.utils.ClickableItemPullRequests
import com.example.avaliacao2githubapi.view_model.RepositoryDetailsViewModel
import com.google.android.material.snackbar.Snackbar

class RepositoryDetailsFragment : Fragment(R.layout.repository_details_fragment), ClickableItemPullRequests {

    companion object {
        fun newInstance(repositoryName: String, username: String) : RepositoryDetailsFragment{
            return RepositoryDetailsFragment().apply {
                val args = Bundle()
                args.putString("repositoryName_parameter", repositoryName)
                args.putString("username_parameter", username)
                this.arguments = args
            }
        }
    }

    private lateinit var viewModel: RepositoryDetailsViewModel
    private lateinit var binding: RepositoryDetailsFragmentBinding
    private var adapter = PullRequestsDetailsAdapter(this)

    private val observerPullDetails = Observer<List<DescriptionRepository>> {
        if(it.isEmpty()){
            Snackbar.make(requireView(), "Esse repositório não possui pull requests", Snackbar.LENGTH_LONG).show()
        } else {
            adapter.refresh(it)
        }
        binding.animationViewGithub.visibility = View.INVISIBLE
    }

    private val observerError = Observer<String> {
        Snackbar.make(requireView(), it, Snackbar.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = RepositoryDetailsFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(RepositoryDetailsViewModel::class.java)

        val repositoryName = arguments?.getString("repositoryName_parameter")
        val username = arguments?.getString("username_parameter")


        binding.recyclerViewRepositoryPullDetails.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewRepositoryPullDetails.adapter = adapter

        viewModel.repositoryDetails.observe(viewLifecycleOwner, observerPullDetails)
        viewModel.error.observe(viewLifecycleOwner, observerError)

        if(!repositoryName.isNullOrEmpty() && !username.isNullOrEmpty()) {
            binding.textViewRepositoryTitle.text = repositoryName
            viewModel.fetchAllPullRequestsFromARepository(repositoryName, username)
        }

        binding.imageViewArrowBack.setOnClickListener {
            (requireActivity() as? MainActivity)?.changeFragments(AllRepositoriesFragment.newInstance())
        }


    }

    override fun onClickList(repo: DescriptionRepository) {
        val openPullRequestBrowser = Intent(Intent.ACTION_VIEW, Uri.parse(repo.urlPullRequest))
        startActivity(openPullRequestBrowser)
    }

    override fun onClickImage(repo: DescriptionRepository) {

        val bottomSheetFrag = UserDetailsFragment.newInstance(repo.userPullRequest.usernameUserPullRequest)

        bottomSheetFrag.show(parentFragmentManager, "dialog_user_description_at_pull_requests")

    }


}