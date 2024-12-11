package com.example.a1revision6.views

import com.example.a1revision6.data.Cat
import com.example.a1revision6.data.User

data class UsersUIState(
    val isLoading: Boolean = false,
    val users: List<Cat> = emptyList(),
    val error: String? = null
)