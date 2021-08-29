package com.example.avaliacao2githubapi.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.avaliacao2githubapi.R
import com.example.avaliacao2githubapi.databinding.AllRepositoriesFragmentBinding
import com.example.avaliacao2githubapi.databinding.RepositoriesFragmentBinding
import com.example.avaliacao2githubapi.view_model.AllRepositoriesViewModel

class AllRepositoriesFragment : Fragment(R.layout.all_repositories_fragment) {

    companion object {
        fun newInstance() = AllRepositoriesFragment()
    }

    private lateinit var viewModel: AllRepositoriesViewModel
    private lateinit var binding: AllRepositoriesFragmentBinding
    private adapter =

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = AllRepositoriesFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(AllRepositoriesViewModel::class.java)



    }

}