package com.pat.githubrestapi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pat.githubrestapi.ApiInterface
import com.pat.githubrestapi.model.RepositoryResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val apiInterface: ApiInterface) : ViewModel() {

    private val _repositoryLiveData = MutableLiveData<RepositoryResponse>()
    val reposiotryLiveData: LiveData<RepositoryResponse> get() = _repositoryLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData


    fun getRepos(key: String) {
        CoroutineScope(Dispatchers.Default).launch {
            try {
                Log.d("ppp", apiInterface.provideGitHubApi().getRepository(key).toString())
                _repositoryLiveData.postValue(apiInterface.provideGitHubApi().getRepository(key))

            } catch (e: Exception) {
                _errorLiveData.postValue(e.message)

            }

        }
    }

}