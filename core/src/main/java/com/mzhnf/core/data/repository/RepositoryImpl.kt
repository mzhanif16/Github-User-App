package com.mzhnf.core.data.repository

import com.mzhnf.core.domain.repository.Repository
import com.mzhnf.core.network.model.ListRepositoryDTO
import com.mzhnf.core.network.model.ListSearchUserDTO
import com.mzhnf.core.network.model.UserDTO
import com.mzhnf.core.network.service.ApiServices
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiServices: ApiServices) :
    Repository {
    override suspend fun login(token: String): Response<UserDTO> {
        return apiServices.login(token)
    }

    override suspend fun getListRepository(
        token: String,
        username: String
    ): Response<ListRepositoryDTO> {
        return apiServices.getListRepository(token,username)
    }

    override suspend fun searchUser(token: String, query: String): Response<ListSearchUserDTO> {
        return apiServices.searchUser(token,query)
    }
}