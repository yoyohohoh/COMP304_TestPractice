package com.example.a1revision6.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

// without networking
//class UsersRepositoryImpl: UsersRepository {
//    override fun getUsers(): List<User>{
//        return listOf(
//            User(1, "Alan", "Aaron"),
//            User(2, "Bob","Bosco"),
//            User(3, "Carmen", "Coco")
//        )
//    }
//}

// with networking
class UsersRepositoryImpl(
    private  val catsAPI: CatsAPI,
    private val dispatcher: CoroutineDispatcher
): UsersRepository {
    override suspend fun getUsers(): NetworkResult<List<Cat>> {
        return withContext(dispatcher) {
            try {
                val response = catsAPI.fetchCats("cute")
                if (response.isSuccessful) {
                    NetworkResult.Success(response.body()!!)
                } else {
                    NetworkResult.Error(response.errorBody().toString())
                }
            } catch (e: Exception) {
                NetworkResult.Error(e.message ?: "Unknown error")
            }
        }
    }
}