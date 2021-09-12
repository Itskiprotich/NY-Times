package com.example.times.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.times.HomeFeed
import com.example.times.adapters.MainAdapter
import com.example.times.R
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.adapter = MainAdapter()

        fetchJson()
    }

    private fun fetchJson() {

        val url = "https://api.nytimes.com/svc/mostpopular/v2/viewed/7.json?api-key=yoilOdJi2A0wUj074USAvIhhHBTNyHil"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {

                val body = response.body?.string()

                val gson = GsonBuilder().create()

                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                runOnUiThread {
                    recyclerView.adapter = MainAdapter(homeFeed)
                }

            }

            override fun onFailure(call: Call, e: IOException) {

            }
        })
    }
}
