package com.mzhnf.githubuser.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mzhnf.core.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mzhnf.core.utils.Resource
import com.mzhnf.githubuser.state.ListRepositoryState
import com.mzhnf.githubuser.state.UserState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {
    private val _userResponse = MutableLiveData<UserState>()
    val userData: LiveData<UserState> = _userResponse
    private val _listRepositoryResponse = MutableLiveData<ListRepositoryState>()
    val listRepositoryData: LiveData<ListRepositoryState> = _listRepositoryResponse
    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean> get() = _isLoggedIn

    fun login(token: String) {
        useCase.login(token).map { result ->
            when (result) {
                is Resource.Success -> {
                    _userResponse.postValue(UserState(success = result.data))
                }

                is Resource.Error -> {
                    _userResponse.value =
                        UserState(error = result.message ?: "Something went wrong")

                }

                is Resource.Loading -> {
                    _userResponse.value = UserState(isLoading = true)

                }

                else -> {
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getListRepository() {
        useCase.getListRepository().map { result ->
            when (result) {
                is Resource.Success -> {
                    _listRepositoryResponse.postValue(ListRepositoryState(success = result.data))
                }

                is Resource.Error -> {
                    _listRepositoryResponse.value =
                        ListRepositoryState(error = result.message ?: "Something went wrong")

                }

                is Resource.Loading -> {
                    _listRepositoryResponse.value = ListRepositoryState(isLoading = true)

                }

                else -> {
                }
            }
        }.launchIn(viewModelScope)
    }

    fun checkLoginStatus() {
        viewModelScope.launch {
            val loggedIn = useCase.isLoggedIn()
            _isLoggedIn.postValue(loggedIn)
        }
    }
}