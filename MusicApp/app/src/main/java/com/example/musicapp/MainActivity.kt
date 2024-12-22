package com.example.musicapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val api = retrofit.create(ApiInterface::class.java)
        val call = api.getMyData("eminem")

        call.enqueue(object : Callback<List<MyData>> {
            override fun onResponse(call: Call<List<MyData>>, response: Response<List<MyData>>) {
                if (response.isSuccessful) {
                    val dataList = response.body() ?: emptyList()
                    val textView = findViewById<TextView>(R.id.text_view)
                    textView.text = dataList.joinToString("\n") { "Country: ${it.country}, ISO: ${it.countryIso}" }
                } else {
                    Log.e("MainActivity", "Response error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<MyData>>, t: Throwable) {
                Log.e("MainActivity", "API call failed: ${t.message}")
            }
        })
    }
}
