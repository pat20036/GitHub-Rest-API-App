package com.pat.githubrestapi

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.pat.githubrestapi.interfaces.GitHubApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiInterface
{
    fun provideGitHubApi(): GitHubApiInterface
}

class GitHubInterfaceImpl: ApiInterface
{
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
    override fun provideGitHubApi(): GitHubApiInterface {
    return retrofit.create(GitHubApiInterface::class.java)
    }

}