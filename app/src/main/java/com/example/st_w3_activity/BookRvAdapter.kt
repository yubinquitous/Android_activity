package com.example.st_w3_activity

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BookRvAdapter(private val context: Context): RecyclerView.Adapter<BookRvAdapter.ViewHolder>() {
    val item_bestsellers = ArrayList<BestSellers>()

    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }
    private lateinit var itemClickListener: ItemClickListener

    //클릭리스너 등록 매소드
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookRvAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookRvAdapter.ViewHolder, position: Int) {
        holder.bind(item_bestsellers[position])

        holder.itemView.setOnClickListener{
            itemClickListener.onClick(it, position)
        }
    }

    fun getItem(position: Int) : BestSellers{
        return item_bestsellers[position]
    }

    override fun getItemCount(): Int {
        Log.d("itemCount success", "${item_bestsellers.size}")
        return item_bestsellers.size
    }

    fun addItems(items: ArrayList<BestSellers>){
        this.item_bestsellers.addAll(items)
        notifyDataSetChanged()  //변경된 data 적용
    }

    inner class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!){
        val coverIv : ImageView = itemView?.findViewById(R.id.item_book_cover_iv)!!
        val titleTv : TextView = itemView?.findViewById(R.id.item_book_title_tv)!!
        val authorTv : TextView = itemView?.findViewById(R.id.item_book_author_tv)!!
        val publisherTv : TextView = itemView?.findViewById(R.id.item_book_publisher_tv)!!

        fun bind(item: BestSellers) {
            Glide.with(context)
                .load(item.imageUrl)
                .into(coverIv)

            titleTv.text = item.title
            authorTv.text = item.author
            publisherTv.text = item.publisher
        }
    }

}