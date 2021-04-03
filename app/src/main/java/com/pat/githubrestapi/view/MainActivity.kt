package com.pat.githubrestapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.pat.githubrestapi.GitHubInterfaceImpl
import com.pat.githubrestapi.R
import com.pat.githubrestapi.RecyclerAdapter
import com.pat.githubrestapi.databinding.ActivityMainBinding
import com.pat.githubrestapi.model.RepositoryItem
import com.pat.githubrestapi.model.RepositoryResponse
import com.pat.githubrestapi.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private lateinit var binding: ActivityMainBinding
    private val items = mutableListOf<RepositoryItem>()
    private val adapter by lazy { RecyclerAdapter(items) }

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.repoRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.repoRecyclerView.adapter = adapter

        binding.searchRepoButton.setOnClickListener()
        {
            val repoName = binding.repoNameEditText.editText?.text.toString()
            binding.repoNameEditText.clearFocus()
            adapter.clearList()
            binding.infoLayout.visibility = View.INVISIBLE
            binding.repoProgressBar.visibility = View.VISIBLE
            viewModel.getRepos(repoName)
        }
        showError()
        updateRepositoryList()
    }

    private fun updateRepositoryList() {
        viewModel.reposiotryLiveData.observe(this, Observer {
            binding.repoProgressBar.visibility = View.INVISIBLE
            adapter.updateList(it)
        })
    }

    private fun showError() {
        viewModel.errorLiveData.observe(this, Observer {
            adapter.clearList()
            binding.infoLayout.visibility = View.VISIBLE
            binding.repoProgressBar.visibility = View.INVISIBLE
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

}
