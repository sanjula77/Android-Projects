package com.example.newsapp

import retrofit2.Call

class NewsRepository(private val apiService: ApiService) {
    fun getTopHeadlines(apiKey: String, callback: (List<Article>) -> Unit) {
        val call = apiService.getTopHeadlines(apiKey = apiKey)
        call.enqueue(object : retrofit2.Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: retrofit2.Response<NewsResponse>) {
                if (response.isSuccessful) {
                    callback(response.body()?.articles ?: emptyList())
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                callback(emptyList())
            }
        })
    }
}