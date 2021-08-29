package com.example.avaliacao2githubapi.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.avaliacao2githubapi.R
import com.example.avaliacao2githubapi.databinding.UserDetailsFragmentBinding
import com.example.avaliacao2githubapi.model.UserInformation
import com.example.avaliacao2githubapi.view_model.UserDetailsViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar

class UserDetailsFragment : BottomSheetDialogFragment() {

    companion object {
        fun newInstance(authorUsername: String) : UserDetailsFragment {

            return UserDetailsFragment().apply {
                val args = Bundle()
                args.putString("username_details_key", authorUsername)
                this.arguments = args
            }

        }
    }

    private lateinit var viewModel: UserDetailsViewModel
    private lateinit var binding: UserDetailsFragmentBinding
    private var authorFetchDetails: String? = ""

    private val observerInformation = Observer<UserInformation> {

        Glide.with(requireView()).load(it.avatarUrl).into(binding.imageViewAvatarDetailsImage)
        binding.textViewUsernameDetails.text = authorFetchDetails!!
        binding.textViewNameDetails.text = it.name
        binding.textViewLocationDetails.text = it.location
        binding.textViewBioDetails.text = it.bio
    }

    private val observerError = Observer<String> {
        Snackbar.make(requireView(), it, Snackbar.LENGTH_LONG).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_details_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = UserDetailsFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(UserDetailsViewModel::class.java)

        authorFetchDetails = arguments?.getString("username_details_key")

        viewModel.userInformation.observe(viewLifecycleOwner, observerInformation)
        viewModel.error.observe(viewLifecycleOwner, observerError)

        if(!authorFetchDetails.isNullOrEmpty()) {
            viewModel.fetchUserData(authorFetchDetails!!)
        }

    }

    override fun getTheme() = R.style.CustomBottomSheetDialog


}