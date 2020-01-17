package com.equipe4.apptest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.equipe4.apptest.journey.JourneyScreen1
import com.equipe4.apptest.messaging.MessagerieList
import kotlinx.android.synthetic.main.activity_journey_screen2.*

class UserProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val sharedPreferences = getSharedPreferences("profilePreferences", 0)
        val firstName = sharedPreferences.getString("firstName", "").plus(" ")
        val lastName = sharedPreferences.getString("lastName", "")
        val gender = sharedPreferences.getString("gender", "")
        val age = sharedPreferences.getString("age", "")
        val email = sharedPreferences.getString("email", "")
        val bio = sharedPreferences.getString("bio", "")

        val nameTextView : TextView = findViewById(R.id.text_view_name)
        val ageTextView : TextView = findViewById(R.id.text_view_age)
        val bioTextView : TextView = findViewById(R.id.text_view_bio)

        nameTextView.text = firstName.plus(lastName).plus(", ")
        ageTextView.text = age.plus(" ans")
        bioTextView.text = bio

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
