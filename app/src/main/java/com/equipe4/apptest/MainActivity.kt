package com.equipe4.apptest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Menu
import android.view.MenuItem
import com.equipe4.apptest.subscription.SubscriptionScreen1
import kotlinx.android.synthetic.main.activity_main.*

import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(bottom_bar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottomappbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.app_bar_profile -> Toast.makeText(this, "profile item is clicked!", Toast.LENGTH_LONG).show()
            R.id.app_bar_messages -> Toast.makeText(this, "messages item is clicked!", Toast.LENGTH_LONG).show()

        }

        return true
    }

    fun goToSubscribe1(view: View){
        val intent = Intent(this, SubscriptionScreen1::class.java)
        startActivity(intent)
    }

    fun goToLogin(view: View){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}