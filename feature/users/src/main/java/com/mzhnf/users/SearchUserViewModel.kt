package com.mzhnf.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mzhnf.core.domain.usecase.UseCase
import com.mzhnf.core.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class SearchUserViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {
    private val _searchUserResponse = MutableLiveData<SearchUserState>()
    val searchUserData: LiveData<SearchUserState> = _searchUserResponse

    fun searchUser(query:String) {
        useCase.searchUser(query).map { result ->
            when (result) {
                is Resource.Success -> {
                    _searchUserResponse.postValue(SearchUserState(success = result.data))
                }

                is Resource.Error -> {
                    _searchUserResponse.value =
                        SearchUserState(error = result.message ?: "Something went wrong")

                }

                is Resource.Loading -> {
                    _searchUserResponse.value = SearchUserState(isLoading = true)

                }

                else -> {
                }
            }
        }.launchIn(viewModelScope)
    }
}