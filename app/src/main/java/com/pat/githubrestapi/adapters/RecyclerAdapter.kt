package com.pat.githubrestapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.pat.githubrestapi.model.RepositoryItem
import com.pat.githubrestapi.model.RepositoryResponse
import com.pat.githubrestapi.viewmodel.MainViewModel

class RecyclerAdapter(val items: MutableList<RepositoryItem>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val repoName = view.findViewById<TextView>(R.id.appNameTextView)
        val fullRepoName = view.findViewById<TextView>(R.id.fullAppNameTextView)
        val language = view.findViewById<TextView>(R.id.languageTextView)
        val stars = view.findViewById<TextView>(R.id.starsTextView)
        val description = view.findViewById<TextView>(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val apiItem = layoutInflater.inflate(R.layout.repo_item, parent, false)
        return ViewHolder(apiItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.apply {
            repoName.text = item.name
            language.text = item.language
            fullRepoName.text = item.fullName
            description.text = item.description
            stars.text = item.stars.toString()

        }
    }

    override fun getItemCount() = items.size


    fun updateList(repositoryResponse: RepositoryResponse) {
        items.clear()
        items.addAll(repositoryResponse.list)
        notifyDataSetChanged()
    }

    fun clearList()
    {
        items.clear()
        notifyDataSetChanged()
    }

}
