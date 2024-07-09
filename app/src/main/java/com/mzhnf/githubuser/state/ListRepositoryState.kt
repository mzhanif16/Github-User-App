package com.mzhnf.githubuser.state

import com.mzhnf.core.model.ListRepositoryModel

data class ListRepositoryState(
val isLoading: Boolean = false,
val error: String = "",
val success: ListRepositoryModel? = null
)
