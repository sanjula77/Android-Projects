package com.example.newsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String
    ): Call<NewsResponse>
}