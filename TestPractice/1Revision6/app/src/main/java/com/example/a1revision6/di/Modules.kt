package com.example.a1revision6.di

import com.example.a1revision6.data.CatsAPI
import com.example.a1revision6.data.UsersRepository
import com.example.a1revision6.data.UsersRepositoryImpl
import com.example.a1revision6.viewmodel.UsersViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import kotlinx.coroutines.Dispatchers
import okhttp3.MediaType.Companion.toMediaType
import kotlinx.serialization.json.Json

// without networking
//val appModules = module {
//    single<UsersRepository> { UsersRepositoryImpl() }
//    single { UsersViewModel(get()) }
//}

// with networking
private val json = Json {
    ignoreUnknownKeys = true
    isLenient = true
}

val appModules = module {
    single<UsersRepository> { UsersRepositoryImpl(get(), get()) }
    single { Dispatchers.IO }
    single { UsersViewModel(get()) }
    single {
        Retrofit.Builder()
            .addConverterFactory(
                json.asConverterFactory(contentType = "application/json".toMediaType())
            )
            .baseUrl("https://cataas.com/api/")
            .build()
    }
    single { get<Retrofit>().create(CatsAPI::class.java) }
}