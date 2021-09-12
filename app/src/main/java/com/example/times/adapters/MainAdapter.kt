package com.ny.times.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.times.views.DetailsScreen
import com.ny.times.HomeFeed
import com.ny.times.R
import java.util.*
import kotlin.collections.ArrayList
import android.widget.AdapterView.OnItemClickListener




class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<MainAdapter.CustomViewHolder>() {

    private var listener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(itemView: View?, position: Int)
    }
    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
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


    }


    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val description: TextView = itemView.findViewById(R.id.tvDescription)
        val date: TextView = itemView.findViewById(R.id.tvDate)

        init {
            itemView.setOnClickListener {
                val toast = Toast.makeText(itemView.context, "please wait..", Toast.LENGTH_LONG)
                toast.show()

            }
        }
    }



}