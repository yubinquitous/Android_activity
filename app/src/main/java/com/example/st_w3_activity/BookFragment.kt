package com.example.st_w3_activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BookFragment : Fragment() {
    private val KEY = "D9A35171119C2F188B64E0E990104B2A240969F9539BF073B4476980FD9CCDFA"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_book, container, false)
        getBooks(101, "json")

        return view.rootView
//        return view   //원래코드
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://book.interpark.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun getBooks(categoryId: Int, output: String) {
        val bookService = retrofit.create(BookService::class.java)
        val callGetBooks = bookService.getBooks(KEY, categoryId, output)

        callGetBooks.enqueue(object : Callback<BookResponse> {
            override fun onResponse(
                call: Call<BookResponse>,
                response: Response<BookResponse>
            ) {
                val result = response.body()
                Log.d("GET-Book_LIST SUCCESS", "${response.raw()}")
                result?.let {
                    Log.d("GET-Book_LIST SUCCESS", "${result.item}")
                    //recyclerview 넣기
                    val recyclerView = view?.findViewById<RecyclerView>(R.id.book_recyclerview)
                    val lm = LinearLayoutManager(requireActivity())
                    val rvAdapter = BookRvAdapter(requireActivity())
                    recyclerView?.layoutManager = lm
                    //클릭 시 상세정보

                    rvAdapter.setItemClickListener(object: BookRvAdapter.ItemClickListener {
                        override fun onClick(view: View, position: Int){
                            val book = rvAdapter.getItem(position)
                            val intent = Intent(requireActivity(), BookInfoActivity::class.java)
                            Log.d("onClick Success", "$book")
                            intent.putExtra("book_description", book.description)
                            intent.putExtra("book_title", book.title)
                            intent.putExtra("book_coverLargeUrl", book.coverLargeUrl)
                            intent.putExtra("book_author", book.author)
                            intent.putExtra("book_publisher", book.publisher)
                            intent.putExtra("book_categoryName", book.categoryName)
//                            intent.putExtra("book_priceSales", book.priceSales)
                            intent.putExtra("book_pubDate", book.pubDate)

                            startActivity(intent)
                        }
                    })
                    rvAdapter.addItems(result.item)
                    recyclerView?.adapter = rvAdapter
                }
            }
            override fun onFailure(
                call: Call<BookResponse>,
                t: Throwable
            ) {   //timeout 등등 요청실패시
                Log.d("GET-Book_LIST FAIL", t.message!!)
            }
        })
    }
}