package com.example.newsapp

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(private var articles: List<Article>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = articles[position]
        holder.title.text = article.title
        holder.description.text = article.description
        Glide.with(holder.itemView.context).load(article.urlToImage).into(holder.image)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, NewsDetailActivity::class.java)
            intent.putExtra("ARTICLE_URL", article.url)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = articles.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateArticles(newArticles: List<Article>) {
        articles = newArticles
        notifyDataSetChanged() // Refresh the RecyclerView
    }


    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.newsTitle)
        val description: TextView = view.findViewById(R.id.newsDescription)
        val image: ImageView = view.findViewById(R.id.newsImage)
    }
}

