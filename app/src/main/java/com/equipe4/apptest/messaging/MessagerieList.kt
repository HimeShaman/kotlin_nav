package com.equipe4.apptest.messaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.equipe4.apptest.R
import kotlinx.android.synthetic.main.messagerie_list.*
import android.view.Menu

import android.view.MenuInflater

class MessagerieList : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.messagerie_list)

        //recyclerView_messagerieList.setBackgroundColor(Color.BLUE)
        recyclerView_messagerieList.layoutManager = LinearLayoutManager(this)
        recyclerView_messagerieList.adapter = MessagerieAdapter()

    }


}
