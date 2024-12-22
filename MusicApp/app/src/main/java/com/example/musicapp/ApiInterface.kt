package com.example.musicapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @Headers(
        "x-rapidapi-key: YOUR_API_KEY", // Replace with your actual API key
        "x-rapidapi-host: deezerdevs-deezer.p.rapidapi.com"
    )
    @GET("search")
    fun getMyData(
        @Query("q") query: String
    ): Call<List<MyData>> // Return a list of MyData directly
}
