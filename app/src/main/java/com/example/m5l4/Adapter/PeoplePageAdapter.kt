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
import com.example.m5l4.Model.PeoplePage
import com.example.m5l4.Model.Room
import com.example.m5l4.R
import com.google.android.material.imageview.ShapeableImageView

class PeoplePageAdapter(var context: Context, var items:ArrayList<PeoplePage>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_people_page,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val people = items[position]

        if (holder is CustomViewHolder) {
            val profile = holder.profile
            val story = holder.story
            val username = holder.username
            val count = holder.count


            profile?.setImageResource(people.profile)
            story?.setImageResource(people.story)
            username?.text = people.username
            count?.text = people.count.toString()

            if (people.count >= 1) count?.visibility = View.VISIBLE
            else count?.visibility = View.GONE

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    private class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var profile:ShapeableImageView? = null
        var story:ShapeableImageView? = null
        var username:TextView? = null
        var count:TextView? = null

        init {
            profile = view.findViewById(R.id.iv_profile)
            story = view.findViewById(R.id.iv_story)
            username = view.findViewById(R.id.tv_username)
            count = view.findViewById(R.id.tv_count)
        }
    }
}