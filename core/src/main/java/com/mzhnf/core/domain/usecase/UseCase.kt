package com.mzhnf.core.domain.usecase

import com.mzhnf.core.datastore.GithubUserPreferencesDataSource
import com.mzhnf.core.domain.repository.Repository
import com.mzhnf.core.model.ListRepositoryModel
import com.mzhnf.core.model.SearchUserModel
import com.mzhnf.core.model.UserModel
import com.mzhnf.core.network.model.toListRepositoryModel
import com.mzhnf.core.network.model.toSearchUserModel
import com.mzhnf.core.network.model.toUserModel
import com.mzhnf.core.network.model.toUserPref
import com.mzhnf.core.utils.CODE
import com.mzhnf.core.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import java.io.IOException
import javax.inject.Inject

class UseCase @Inject constructor(
    private val repository: Repository,
    private val userPreference: GithubUserPreferencesDataSource
) {
    fun login(
        token: String
    ): Flow<Resource<UserModel>> = flow {
        try {
            emit(Resource.Loading())
            val bearerToken = "Bearer $token"
            val login = repository.login(bearerToken)
            if (login.isSuccessful) {
                val code = login.code()
                if (CODE.contains(code)) {
                    emit(
                        Resource.Error(
                            JSONObject(
                                login.errorBody()!!.string()
                            ).getString("message")
                        )
                    )
                } else {
                    login.body()?.let {
                        val userPref = it.toUserPref(token)
                        userPreference.saveUserData(userPref)
                        emit(Resource.Success(it.toUserModel()))
                    }
                }
            } else {
                emit(
                    Resource.Error(
                        JSONObject(
                            login.errorBody()!!.string()
                        ).getString("message")
                    )
                )
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }

    fun getListRepository(): Flow<Resource<ListRepositoryModel>> = flow {
        try {
            emit(Resource.Loading())
            val bearerToken = "Bearer ${userPreference.getToken()}"
            val userData = userPreference.getUserData()
            val username = userData.value?.login
            val response = repository.getListRepository(bearerToken, username.toString())
            if (response.isSuccessful) {
                val code = response.code()
                if (CODE.contains(code)) {
                    emit(
                        Resource.Error(
                            JSONObject(
                                response.errorBody()!!.string()
                            ).getString("message")
                        )
                    )
                } else {
                    response.body()?.let {
                        emit(Resource.Success(it.toListRepositoryModel()))
                    }
                }
            } else {
                emit(
                    Resource.Error(
                        JSONObject(
                            response.errorBody()!!.string()
                        ).getString("message")
                    )
                )
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }

    fun searchUser(query:String): Flow<Resource<SearchUserModel>> = flow {
        try {
            emit(Resource.Loading())
            val bearerToken = "Bearer ${userPreference.getToken()}"
            val response = repository.searchUser(bearerToken, query)
            if (response.isSuccessful) {
                val code = response.code()
                if (CODE.contains(code)) {
                    emit(
                        Resource.Error(
                            JSONObject(
                                response.errorBody()!!.string()
                            ).getString("message")
                        )
                    )
                } else {
                    response.body()?.let {
                        emit(Resource.Success(it.toSearchUserModel()))
                    }
                }
            } else {
                emit(
                    Resource.Error(
                        JSONObject(
                            response.errorBody()!!.string()
                        ).getString("message")
                    )
                )
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }

    suspend fun isLoggedIn(): Boolean {
        return userPreference.getIsLogin()
    }
}