package com.pat.githubrestapi.model

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
    @SerializedName("items")
    val list: List<RepositoryItem>
)