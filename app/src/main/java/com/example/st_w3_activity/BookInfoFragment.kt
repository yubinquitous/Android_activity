package com.example.st_w3_activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class BookInfoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_bookinfo, container, false)

        var bIvCover: ImageView = view.findViewById(R.id.bookinfo_cover_iv)
        var bTvTitle : TextView = view.findViewById(R.id.bookinfo_title_tv)
        var bTvAuthor : TextView = view.findViewById(R.id.bookinfo_author_tv)
        var bTvPublisher : TextView = view.findViewById(R.id.bookinfo_publisher_tv)
        var bTvDescription : TextView = view.findViewById(R.id.bookinfo_description_tv)

//        val bookCover : String =

        return view
    }
}