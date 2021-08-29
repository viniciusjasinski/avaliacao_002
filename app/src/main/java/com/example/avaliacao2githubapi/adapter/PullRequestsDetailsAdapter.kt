package com.example.avaliacao2githubapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.avaliacao2githubapi.R
import com.example.avaliacao2githubapi.databinding.ItemRepositoryBinding
import com.example.avaliacao2githubapi.model.DescriptionRepository

class PullRequestsDetailsAdapter(val onClickPullRequest: (DescriptionRepository) -> Unit) :
    RecyclerView.Adapter<ItemPullRequestsDetailsViewHolder>() {

    private val listOfPullRequests: MutableList<DescriptionRepository> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemPullRequestsDetailsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_pull_details, parent, false)
        return ItemPullRequestsDetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemPullRequestsDetailsViewHolder, position: Int) {
        listOfPullRequests[position].apply {
            holder.bind(this)
            holder.itemView.setOnClickListener {
                onClickPullRequest(this)
            }
        }
    }

    override fun getItemCount(): Int {
        return listOfPullRequests.size
    }

    fun refresh(newList: List<DescriptionRepository>) {
        listOfPullRequests.clear()
        listOfPullRequests.addAll(newList)
        notifyDataSetChanged()
    }

}


class ItemPullRequestsDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: ItemRepositoryBinding = ItemRepositoryBinding.bind(itemView)

    fun bind(descriptionRepository: DescriptionRepository) {
        binding.textViewRepositoryName.text = descriptionRepository.titlePullRequest
        binding.textViewRepositoryDescription.text = descriptionRepository.bodyPullRequest
        binding.textViewUsername.text = descriptionRepository.userPullRequest.usernameUserPullRequest
        Glide.with(itemView.context)
            .load(descriptionRepository.userPullRequest.avatarUserPullRequest)
            .into(binding.imageViewAvatarImage)
    }

}