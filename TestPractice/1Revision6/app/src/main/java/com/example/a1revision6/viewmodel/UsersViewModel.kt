package com.example.a1revision6.viewmodel

import android.util.Log
import com.example.a1revision6.data.UsersRepository
import androidx.lifecycle.ViewModel // import for view model

import androidx.lifecycle.viewModelScope
import com.example.a1revision6.data.NetworkResult
import com.example.a1revision6.views.UsersUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UsersViewModel(
    private val usersRepository: UsersRepository
): ViewModel(){
    // without networking
    //fun getUsers() = usersRepository.getUsers()

    // with networking
    val usersUIState = MutableStateFlow(UsersUIState())

    init {
        getUsers()
    }

    fun getUsers() {
        usersUIState.value = UsersUIState(isLoading = true)
        viewModelScope.launch {
            when (val result = usersRepository.getUsers()) {
                is NetworkResult.Success -> {
                    usersUIState.update {
                        it.copy(isLoading = false, users = result.data)
                    }
                    Log.d("VM","success")
                }
                is NetworkResult.Error -> {
                    usersUIState.update {
                        it.copy(isLoading = false, error = result.error)
                    }
                    Log.d("VM","fail")
                }
            }
        }
    }
}