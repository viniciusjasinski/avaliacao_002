package com.example.avaliacao2githubapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.avaliacao2githubapi.R
import com.example.avaliacao2githubapi.databinding.ItemRepositoryBinding
import com.example.avaliacao2githubapi.model.RepositoriesDetails

class RepositoriesAdapter(): RecyclerView.Adapter<ItemRepositoriesViewHolder>() {

    private val listOfRepositories: MutableList<RepositoriesDetails> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemRepositoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
        return ItemRepositoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemRepositoriesViewHolder, position: Int) {
        listOfRepositories[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int {
        return listOfRepositories.size
    }

    fun refresh(newList: List<RepositoriesDetails>) {
        listOfRepositories.clear()
        listOfRepositories.addAll(newList)
        notifyDataSetChanged()
    }

}

class ItemRepositoriesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val binding: ItemRepositoryBinding = ItemRepositoryBinding.bind(itemView)

    fun bind(details: RepositoriesDetails) {
        binding.textViewRepositoryName.text = details.repositoryName
        binding.textViewRepositoryDescription.text = details.description
        binding.textViewNumberOfForks.text = details.forks.toString()
        binding.textViewNumberOfStars.text = details.stars.toString()
        binding.textViewUsername.text = details.owner.authorUsername
    }
}