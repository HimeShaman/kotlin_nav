package com.equipe4.apptest.journey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.equipe4.apptest.R
import com.equipe4.apptest.UserProfileActivity
import com.equipe4.apptest.messaging.MessagerieList
import kotlinx.android.synthetic.main.activity_journey_screen1.*
import kotlinx.android.synthetic.main.activity_journey_screen1.bottom_bar
import kotlinx.android.synthetic.main.messagerie_list.*

class JourneyScreen1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey_screen1)

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

    fun doSearch(view:View){
        val searchedJourney = JourneySearch(
            editText_input_journey_start.text.toString(),
            editText_input_journey_end.text.toString(),
            journey_checkbox1_train.isChecked,
            journey_checkbox2_bus.isChecked,
            journey_checkbox3_metro.isChecked ,
            journey_checkbox4_tram.isChecked
        )

        val intentSearch = JourneyScreen2.createIntent(this,searchedJourney)
        startActivity(intentSearch)
        //No finish in order to modify search criteria if journeys aren't satisfying to the user
    }
}
