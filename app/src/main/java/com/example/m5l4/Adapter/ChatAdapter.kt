package com.example.m5l4.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5l4.Model.Chat
import com.example.m5l4.Model.Room
import com.example.m5l4.R
import com.google.android.material.imageview.ShapeableImageView

class ChatAdapter(var context: Context,var items:ArrayList<Chat>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var TYPE_ITEM_ROOM = 0
    private var TYPE_ITEM_MESSSAGE = 1

    override fun getItemViewType(position: Int): Int {
        val feed = items[position]
        if(feed.rooms.size > 0)
            return TYPE_ITEM_ROOM
        return TYPE_ITEM_MESSSAGE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_ROOM){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_room,parent,false)
            return RoomViewHolder(context,view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_message,parent,false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = items[position]

        if (holder is RoomViewHolder){
            var recyclerView = holder.recyclerView
            refreshAdapter(recyclerView,chat.rooms)
        }
        if (holder is MessageViewHolder) {
            val imageView = (holder as MessageViewHolder).imageViewProfile
            val textView = (holder as MessageViewHolder).textViewFullName
            val isOnline = (holder as MessageViewHolder).isOnline


            imageView.setImageResource(chat.message!!.profile)
            textView.text = chat.message!!.fullname

            if (chat.message!!.isOnline) isOnline.visibility = View.VISIBLE
            else isOnline.visibility = View.GONE

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    private fun refreshAdapter(recyclerView: RecyclerView, rooms: ArrayList<Room>) {
        val adapter = RoomAdapter(context, rooms)
        recyclerView.adapter = adapter
    }

    private class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageViewProfile: ShapeableImageView = itemView.findViewById(R.id.iv_profile)
        var textViewFullName: TextView = itemView.findViewById(R.id.tv_fullname)
        var isOnline: LinearLayout = itemView.findViewById(R.id.is_online)
    }
    private class RoomViewHolder(context: Context, itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var recyclerView: RecyclerView = itemView.findViewById(R.id.recyclerView)

        init {
            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }
}