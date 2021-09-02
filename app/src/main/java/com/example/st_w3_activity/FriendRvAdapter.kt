package com.example.st_w3_activity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FriendRvAdapter(private val context: Context): RecyclerView.Adapter<FriendRvAdapter.ViewHolder>(){
    val items = ArrayList<Friend>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_friend, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItems(items: ArrayList<Friend>){
        this.items.addAll(items)
        notifyDataSetChanged()  //변경된 data 적용
    }

    inner class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!){
        val profileIv: ImageView = itemView?.findViewById(R.id.item_friend_profile_iv)!!
        val nicknameTv : TextView = itemView?.findViewById(R.id.item_friend_nickname_tv)!!
        val stateMsgTv: TextView = itemView?.findViewById(R.id.item_friend_state_msg_tv)!!
        val musicTv: TextView = itemView?.findViewById(R.id.item_friend_music_tv)!!

        fun bind(item: Friend){
            Glide.with(context)
                .load(item.profileUrl)
                .circleCrop()
                .into(profileIv)

            nicknameTv.text = item.nickname
            stateMsgTv.text = item.stateMsg
            musicTv.text = item.music
        }
    }

}