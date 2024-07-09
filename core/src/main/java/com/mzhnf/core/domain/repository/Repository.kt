package com.mzhnf.core.domain.repository

import com.mzhnf.core.network.model.ListRepositoryDTO
import com.mzhnf.core.network.model.ListSearchUserDTO
import com.mzhnf.core.network.model.UserDTO
import retrofit2.Response

interface Repository {
    suspend fun login(token: String): Response<UserDTO>
    suspend fun getListRepository(token: String,username:String):Response<ListRepositoryDTO>
    suspend fun searchUser(token: String,query:String):Response<ListSearchUserDTO>
}