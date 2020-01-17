package com.equipe4.apptest.messaging

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.equipe4.apptest.R
import kotlinx.android.synthetic.main.messagerie_list.*
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.equipe4.apptest.UserProfileActivity
import com.equipe4.apptest.journey.JourneyScreen1


class MessagerieList : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.messagerie_list)

        //recyclerView_messagerieList.setBackgroundColor(Color.BLUE)
        recyclerView_messagerieList.layoutManager = LinearLayoutManager(this)
        recyclerView_messagerieList.adapter = MessagerieAdapter()

        setSupportActionBar(bottom_bar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottomappbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        val profileIntent = Intent(this, UserProfileActivity::class.java)
        val messageIntent = Intent(this, MessagerieList::class.java)

        when (item!!.itemId) {
            R.id.app_bar_profile -> startActivity(profileIntent)
            R.id.app_bar_messages -> startActivity(messageIntent)
        }
        return true
    }

    fun goToJourneyScreen(view: View) {
        val intent = Intent(this, JourneyScreen1::class.java)
        startActivity(intent)
    }

}
