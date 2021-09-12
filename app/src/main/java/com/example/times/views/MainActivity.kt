package com.ny.times.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.times.api.url
import com.example.times.interfaces.onItemClickInteface
import com.example.times.views.DetailsScreen
import com.ny.times.HomeFeed
import com.ny.times.adapters.MainAdapter
import com.ny.times.R
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    var news = ArrayList<HomeFeed>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        progressBar.visibility = View.GONE
        fetchJson()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.app_bar_search -> {
                val toast = Toast.makeText(this, "Searching data", Toast.LENGTH_LONG)
                toast.show()
                return true
            }
            R.id.exit_about -> {
                val toast = Toast.makeText(this, "About App", Toast.LENGTH_LONG)
                toast.show()
                return true
            }
            R.id.exit_menu -> {

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Exit App?")
                builder.setMessage("Are you sure you want to exit?")

                builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                    android.os.Process.killProcess(android.os.Process.myPid())
                }

                builder.setNegativeButton(android.R.string.no) { dialog, which ->
                    Toast.makeText(
                        applicationContext,
                        android.R.string.no, Toast.LENGTH_SHORT
                    ).show()
                }


                builder.show()


                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun fetchJson() {

        val request = Request.Builder().url(url).build()
        progressBar.visibility = View.VISIBLE
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {

                val body = response.body?.string()

                val gson = GsonBuilder().create()

                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                news.add(homeFeed)
                runOnUiThread {
                    recyclerView.adapter = MainAdapter(homeFeed)
                    progressBar.visibility = View.GONE

                }

            }

            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    progressBar.visibility = View.GONE
                }
            }
        })
    }


}
