package com.example.navigation1

import android.app.Application
import com.example.navigation1.data.NavRepository

class MyApplication: Application() {
    private lateinit var repository : NavRepository

    override fun onCreate() {
        super.onCreate()
        repository = NavRepository()
    }

    fun getRepository(): NavRepository {
        return repository
    }

}