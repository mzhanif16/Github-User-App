package com.mzhnf.githubuser.state

import com.mzhnf.core.model.UserModel

data class UserState(
val isLoading: Boolean = false,
val error: String = "",
val success: UserModel? = null
)
