package com.example.fitpeokot

import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

class MainActivity2 : AppCompatActivity() {

   private lateinit var title: TextView
   private lateinit var thumbnail: TextView
private lateinit var imagev: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val id = intent.extras!!.getString("id")
        val albumId = intent.extras!!.getString("albumId")
        val thumbnailUrl = intent.extras!!.getString("thumbnailUrl")
        val titlee = intent.extras!!.getString("title")
        val url = intent.extras!!.getString("url")
        Log.d("data1", thumbnailUrl.toString() + albumId.toString())
         title = findViewById<TextView>(R.id.tvTitle)
        thumbnail = findViewById(R.id.tvDescription)
        imagev = findViewById(R.id.imageView)
        title.text =titlee
        thumbnail.text = thumbnailUrl
        Picasso.with(this)
            .load(thumbnailUrl).into(imagev);


    }
}