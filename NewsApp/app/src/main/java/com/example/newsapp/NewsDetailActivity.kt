package com.example.newsapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class NewsDetailActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val webView = findViewById<WebView>(R.id.webView)
        val articleUrl = intent.getStringExtra("ARTICLE_URL")

        if (articleUrl != null) {
            webView.webViewClient = WebViewClient()
            webView.loadUrl(articleUrl)
        }
    }
}
