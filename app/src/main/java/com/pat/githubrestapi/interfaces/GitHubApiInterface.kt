package com.pat.githubrestapi.interfaces

import com.pat.githubrestapi.model.RepositoryItem
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApiInterface {
    @GET("search/repositories")
    suspend fun getRepository(@Query("q") query: String): RepositoryItem

}