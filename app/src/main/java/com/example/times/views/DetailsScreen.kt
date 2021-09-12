package com.example.times.views

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import com.ny.times.R

class DetailsScreen : AppCompatActivity() {
    private var toolbar: Toolbar? = null
    private var txt_title:TextView?=null
    private var text_title:TextView?=null
    private var text_description:TextView?=null
    private var text_author:TextView?=null
    private var text_date:TextView?=null
    private var text_source:TextView?=null
    private var text_updated:TextView?=null
    private var text_section:TextView?=null
    private var link:String?=null


    companion object {
        const val title = "title"
        const val desc = "desc"
        const val author = "author"
        const val date = "date"
        const val source = "source"
        const val updated = "updated"
        const val section = "section"
        const val subsection = "subsection"
        const val url = "url"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_screen)

        val title = intent.getStringExtra(DetailsScreen.title)
        val desc = intent.getStringExtra(DetailsScreen.desc)
        val author = intent.getStringExtra(DetailsScreen.author)
        val date = intent.getStringExtra(DetailsScreen.date)
        val source = intent.getStringExtra(DetailsScreen.source)
        val updated = intent.getStringExtra(DetailsScreen.updated)
        val section = intent.getStringExtra(DetailsScreen.section)
        val subsection = intent.getStringExtra(DetailsScreen.subsection)
         link = intent.getStringExtra(DetailsScreen.url)

        toolbar = findViewById(R.id.toolbar)
        txt_title = findViewById(R.id.txt_title)
        text_title = findViewById(R.id.text_title)
        text_description = findViewById(R.id.text_description)
        text_author = findViewById(R.id.text_author)
        text_date = findViewById(R.id.text_date)
        text_source = findViewById(R.id.text_source)
        text_updated = findViewById(R.id.text_updated)
        text_section = findViewById(R.id.text_section)

        setSupportActionBar(toolbar)
        supportActionBar?.apply {

            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        txt_title!!.text="News Detail"
        text_title!!.text=title
        text_description!!.text=desc
        text_author!!.text=author
        text_date!!.text="Published $date"
        text_source!!.text=source
        text_updated!!.text="Updated $updated"
        text_section!!.text="$section - $subsection"


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.details, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.menu_site -> {
                val toast = Toast.makeText(this, "Loading site", Toast.LENGTH_LONG)
                toast.show()
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse(link)
                startActivity(openURL)
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}