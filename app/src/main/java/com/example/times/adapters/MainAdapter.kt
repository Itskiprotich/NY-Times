package com.ny.times.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ny.times.CourseDetailActivity
import com.ny.times.HomeFeed
import com.ny.times.R

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

        val video = homeFeed.results[position]
        holder.title.text = video.title
        holder.description.text = video.byline
        holder.date.text = video.published_date

       /* val thumbnailImageView = holder.thumb_nail
        Picasso.with(holder.itemView.context).load(video.imageUrl).into(
            thumbnailImageView
        )

        val channelImageView = holder.channel_image
        Picasso.with(holder.itemView.context).load(video.channel.profileImageUrl).into(
            channelImageView
        )*/
    }


    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView.findViewById(R.id.tvTitle)

        val description: TextView = itemView.findViewById(R.id.tvDescription)

        val date: TextView = itemView.findViewById(R.id.tvDate)


        init {
            itemView.setOnClickListener {

                val intent = Intent(itemView.context, CourseDetailActivity::class.java)
                itemView.context.startActivity(intent)
            }
        }
    }



}