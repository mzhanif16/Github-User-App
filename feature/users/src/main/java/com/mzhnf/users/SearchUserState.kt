package com.mzhnf.users

import com.mzhnf.core.model.SearchUserModel

data class SearchUserState(
val isLoading: Boolean = false,
val error: String = "",
val success: SearchUserModel? = null
)
