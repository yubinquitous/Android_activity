package com.example.st_w3_activity

import android.os.Bundle
import android.os.PersistableBundle
import android.text.Layout
import android.text.method.ScrollingMovementMethod
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class BookInfoActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookinfo)

    }

    override fun onStart() {
        super.onStart()

        val bIvCover: ImageView = findViewById(R.id.bookinfo_cover_iv)
        val bTvTitle: TextView = findViewById(R.id.bookinfo_title_tv)
        val bTvAuthor: TextView = findViewById(R.id.bookinfo_author_tv)
        val bTvPubDate : TextView = findViewById(R.id.bookinfo_pubdate_tv)
        val bTvPublisher: TextView = findViewById(R.id.bookinfo_publisher_tv)
        val bTvDescription: TextView = findViewById(R.id.bookinfo_description_tv)
        var bCoverUrl : String? = null

        bTvDescription.setMovementMethod(ScrollingMovementMethod())

        if (intent.hasExtra("book_coverLargeUrl") && intent.hasExtra("book_title") && intent.hasExtra("book_description") && intent.hasExtra("book_author") && intent.hasExtra("book_publisher") && intent.hasExtra("book_pubDate")) {
//            Toast.makeText(applicationContext, "activity전환", Toast.LENGTH_LONG).show()
            bCoverUrl= intent.getStringExtra("book_coverLargeUrl").toString()
            bTvTitle.text = intent.getStringExtra("book_title")
            bTvDescription.text = intent.getStringExtra("book_description")
            bTvAuthor.text = intent.getStringExtra("book_author").toString()
            bTvPublisher.text = intent.getStringExtra("book_publisher").toString()
            bTvPubDate.text = intent.getStringExtra("book_pubDate").toString()
        }


        Glide.with(this)
            .load(bCoverUrl)
            .into(bIvCover)
    }
}