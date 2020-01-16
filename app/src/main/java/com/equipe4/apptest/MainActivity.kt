package com.equipe4.apptest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.equipe4.apptest.journey.JourneyScreen1
import com.equipe4.apptest.subscription.SubscriptionScreen1


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

    fun goToJourneyScreen(view: View) {
        val intent = Intent(this, JourneyScreen1::class.java)
        startActivity(intent)
    }
}