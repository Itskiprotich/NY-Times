package com.example.times

class HomeFeed(val results: List<News>)

class News(
    val source: String,
    val title: String,
    val byline: String,
    val published_date : String
)
