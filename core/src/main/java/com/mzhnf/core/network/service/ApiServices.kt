package com.mzhnf.core.network.service

import com.mzhnf.core.network.model.ListRepositoryDTO
import com.mzhnf.core.network.model.ListSearchUserDTO
import com.mzhnf.core.network.model.UserDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {
    @GET("user")
    suspend fun login(
        @Header("Authorization") token: String
    ):Response<UserDTO>

    @GET("users/{username}/repos?per_page=30&page=1")
    suspend fun getListRepository(
        @Header("Authorization") token: String,
        @Path("username") username:String
    ):Response<ListRepositoryDTO>

    @GET("search/users")
    suspend fun searchUser(
        @Header("Authorization") token: String,
        @Query("q") query: String
    ):Response<ListSearchUserDTO>
}