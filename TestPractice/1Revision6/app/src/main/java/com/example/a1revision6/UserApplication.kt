package com.example.a1revision6

import android.app.Application
import com.example.a1revision6.di.appModules
import org.koin.core.context.startKoin

class UserApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModules)
        }
    }
}