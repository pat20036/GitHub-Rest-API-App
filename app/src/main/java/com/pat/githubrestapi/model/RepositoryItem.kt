package com.pat.githubrestapi.model

import com.google.gson.annotations.SerializedName

data class RepositoryItem(
    val name: String,
    val description: String,
    val language: String,
    val id: Long,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("stargazers_count")
    val stars: Int
)