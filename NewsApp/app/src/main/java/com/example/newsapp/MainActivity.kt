package com.example.newsapp

import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var newsAdapter: NewsAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerView)
        val searchView = findViewById<SearchView>(R.id.searchView)
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)

        newsAdapter = NewsAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = newsAdapter

        loadNews()

        swipeRefreshLayout.setOnRefreshListener {
            loadNews()
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { searchNews(it) }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun loadNews() {
        swipeRefreshLayout.isRefreshing = true

        val apiService = ApiClient.retrofit.create(ApiService::class.java)
        val call = apiService.getTopHeadlines(country = "us", apiKey = "c43b6ee3e4234485b39cd2a248d0b045") // Replace "us" with your desired country code

        call.enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                swipeRefreshLayout.isRefreshing = false
                if (response.isSuccessful && response.body() != null) {
                    newsAdapter.updateArticles(response.body()!!.articles)
                } else {
                    Log.e("API_ERROR", "Response Code: ${response.code()}, Message: ${response.message()}")
                    Toast.makeText(this@MainActivity, "Failed to load news: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                swipeRefreshLayout.isRefreshing = false
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun searchNews(query: String) {
        swipeRefreshLayout.isRefreshing = true

        val apiService = ApiClient.retrofit.create(ApiService::class.java)
        val call = apiService.getTopHeadlines(country = "us", apiKey = "c43b6ee3e4234485b39cd2a248d0b045") // Replace "us" with your desired country code

        call.enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                swipeRefreshLayout.isRefreshing = false
                if (response.isSuccessful && response.body() != null) {
                    val filteredArticles = response.body()!!.articles.filter {
                        it.title.contains(query, true) || (it.description?.contains(query, true) == true)
                    }
                    newsAdapter.updateArticles(filteredArticles)
                } else {
                    Log.e("API_ERROR", "Response Code: ${response.code()}, Message: ${response.message()}")
                    Toast.makeText(this@MainActivity, "Failed to load news: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                swipeRefreshLayout.isRefreshing = false
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }


}
