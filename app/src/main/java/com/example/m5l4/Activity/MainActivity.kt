package com.example.m5l4.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5l4.Adapter.ChatAdapter
import com.example.m5l4.Adapter.PeoplePageAdapter
import com.example.m5l4.Model.Chat
import com.example.m5l4.Model.Message
import com.example.m5l4.Model.PeoplePage
import com.example.m5l4.Model.Room
import com.example.m5l4.R

class MainActivity : AppCompatActivity(){
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_people_page)

        initViews()
    }
    fun initViews(){
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this,2))

        refreshAdapter(getAllChats())
    }

//    fun refreshAdapter(chats:ArrayList<Chat>){
//        val adapter = ChatAdapter(this,chats)
//        recyclerView.adapter = adapter
//    }

    fun refreshAdapter(people:ArrayList<PeoplePage>){
        val adapter = PeoplePageAdapter(this,people)
        recyclerView.adapter = adapter
    }



    fun getAllChats():ArrayList<PeoplePage>{
        val people:ArrayList<PeoplePage> = ArrayList()

        people.add(PeoplePage(R.mipmap.ic_plus,R.drawable.img,"Add to Story",0))
        people.add(PeoplePage(R.drawable.img_1,R.drawable.story_1,"Bog'ibek Matyaqubov",1))
        people.add(PeoplePage(R.drawable.img_2,R.drawable.story_2,"Odilbek Mirzayev",4))
        people.add(PeoplePage(R.drawable.img_3,R.drawable.story_3,"Kun uz",10))
        people.add(PeoplePage(R.drawable.img_4,R.drawable.story_4,"Najot Ta'lim",3))
        people.add(PeoplePage(R.drawable.img_5,R.drawable.story_5,"Абдусаттор Абдураҳимов",2))
        people.add(PeoplePage(R.drawable.img_6,R.drawable.story_6,"Alisher Avazov",5))
        people.add(PeoplePage(R.drawable.img_7,R.drawable.story_7,"Ibrahim Gulyamov",7))
        people.add(PeoplePage(R.drawable.img_8,R.drawable.story_8,"The fastest growing religion",4))
        people.add(PeoplePage(R.drawable.img_9,R.drawable.story_9,"Fossbytes",1))

        return people

        /*val stories:ArrayList<Room> = ArrayList()

        stories.add(Room(R.mipmap.ic_create_room,"Create Room"))
        stories.add(Room(R.drawable.img,"Yahya Mahmudiy"))
        stories.add(Room(R.drawable.img,"Yahya Mahmudiy"))
        stories.add(Room(R.drawable.img,"Yahya Mahmudiy"))
        stories.add(Room(R.drawable.img,"Yahya Mahmudiy"))
        stories.add(Room(R.drawable.img,"Yahya Mahmudiy"))

        val chats = ArrayList<Chat>()
        chats.add(Chat(rooms = stories))

        for (i in 1..5) {
            chats.add(Chat(Message(R.drawable.img, "Yahya Mahmudiy", true)))
            chats.add(Chat(Message(R.drawable.img, "Yahya Mahmudiy")))
        }
        return chats*/
    }
}