package com.example.a1revision6.data

interface UsersRepository {
    // wihtout networking
    //fun getUsers(): List<User>

    // with networking
    suspend fun getUsers(): NetworkResult<List<Cat>>
}