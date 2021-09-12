package com.ny.times

class HomeFeed(val results: List<News>)

class News(
    val uri: String,
    val url: String,
    val id: String,
    val source : String,
    val published_date: String,
    val updated: String,
    val section: String,
    val subsection : String,
    val nytdsection: String,
    val adx_keywords: String,
    val column: String,
    val byline : String,
    val type : String,
    val title: String,
    val abstract: String,
    val eta_id: Int

)
