package com.example.m5l4.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m5l4.Model.Room
import com.example.m5l4.R
import com.google.android.material.imageview.ShapeableImageView

class RoomAdapter(private val context: Context, private val rooms: ArrayList<Room>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(context).inflate(R.layout.item_chat_view, parent, false)
        return RoomViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val room = rooms[position]

        if (holder is RoomViewHolder) {
            val imageView = (holder as RoomViewHolder).imageViewProfile
            val textView = (holder as RoomViewHolder).textViewFullName
            val isOnline = (holder as RoomViewHolder).linearLayout

            imageView.setImageResource(room.profile)
            textView.text = room.fullname

            if (room.fullname=="Create Room") isOnline.visibility = View.GONE
            else isOnline.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return rooms.size
    }

    private class RoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewProfile: ShapeableImageView = itemView.findViewById(R.id.iv_profile)
        val textViewFullName: TextView = itemView.findViewById(R.id.tv_fullname)
        val linearLayout:LinearLayout = itemView.findViewById(R.id.isOnline)
    }
}