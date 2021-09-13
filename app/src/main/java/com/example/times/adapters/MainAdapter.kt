package com.ny.times.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.times.views.DetailsScreen
import com.ny.times.HomeFeed
import com.ny.times.R
import okhttp3.Callback

class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<MainAdapter.CustomViewHolder>() {

    override fun getItemCount(): Int {
        return homeFeed.results.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.news_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val news = homeFeed.results[position]
        holder.title.text = news.title
        holder.description.text = news.byline
        holder.date.text = news.published_date
        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context, DetailsScreen::class.java)
            intent.putExtra(DetailsScreen.desc, news.abstract)
            intent.putExtra(DetailsScreen.source, news.source)
            intent.putExtra(DetailsScreen.updated, news.updated)
            intent.putExtra(DetailsScreen.section, news.section)
            intent.putExtra(DetailsScreen.subsection, news.subsection)
            intent.putExtra(DetailsScreen.nytdsection, news.nytdsection)
            intent.putExtra(DetailsScreen.adx_keywords, news.adx_keywords)
            intent.putExtra(DetailsScreen.url, news.url)
            intent.putExtra(DetailsScreen.title, news.title)
            intent.putExtra(DetailsScreen.author, news.byline)
            intent.putExtra(DetailsScreen.date, news.published_date)
            holder.itemView.context.startActivity(intent)
        }

    }


    class CustomViewHolder(itemView: View, var collected: HomeFeed? = null) :
        RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val description: TextView = itemView.findViewById(R.id.tvDescription)
        val date: TextView = itemView.findViewById(R.id.tvDate)


    }


}

